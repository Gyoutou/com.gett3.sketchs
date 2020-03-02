package sketch.basic.online.config;

import java.io.File;
import java.util.concurrent.TimeUnit;

import javax.servlet.Filter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import jp.gtf.kernel.lang.utils.UString;

@EnableWebMvc
@Configuration
public class MvcConfiguration implements WebMvcConfigurer {

    private static final String EXTERNAL_RES_DIR;
    public static final String EXTERNAL_RES_URL;

    static {
        EXTERNAL_RES_DIR = "/data/resources/jp.jphome.online/public/";
        EXTERNAL_RES_URL = "/external/";
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/")
            .setCacheControl(CacheControl.maxAge(60, TimeUnit.MINUTES));
        registry.addResourceHandler("/public/**").addResourceLocations("classpath:/public/");

        if(isWindows()) {
            registry.addResourceHandler(EXTERNAL_RES_URL + "**").addResourceLocations("file:///C:" + EXTERNAL_RES_DIR);
            File externalResDir = new File("C:" + EXTERNAL_RES_DIR);
            if(!externalResDir.exists()) {
                externalResDir.mkdirs();
            };

        } else {
            registry.addResourceHandler(EXTERNAL_RES_URL + "**").addResourceLocations("file:" + EXTERNAL_RES_DIR);
            File externalResDir = new File(EXTERNAL_RES_DIR);
            if(!externalResDir.exists()) {
                externalResDir.mkdirs();
            };
        }
    }

    @Bean
    public Filter characterEncodingFilter() {
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("UTF-8");
        filter.setForceEncoding(true);
        return filter;
    }

    private static String OS = System.getProperty("os.name").toLowerCase();

    private static boolean isWindows() {
        return (OS.indexOf("win") >= 0);
    }

    /**
     * リソースロケーションを取得する
     * @return
     */
    public static String getPhysicResourceLocation() {
        if(isWindows()) {
            return "C:" + EXTERNAL_RES_DIR;
        }
        return EXTERNAL_RES_DIR;
    }

    /**
     * 指定されたパス
     * @param directory
     * @return
     */
    public static StringBuilder getPublicDirOf(String directory) {
        if(directory.endsWith("/"))
            return new StringBuilder(getPhysicResourceLocation()).append(directory);
        return new StringBuilder(getPhysicResourceLocation()).append(directory).append("/");
    }

    /**
     * 指定されたパス
     * @param directory
     * @return
     */
    public static StringBuilder getPublicTmpDir() {
        return getPublicDirOf("tmp");
    }

    /**
     * 指定されたパスのファイルを取得する
     * @param filename
     * @return
     */
    public static File getPublicTmpFile(String filename) {
        return new File(getPublicTmpDir().append(filename).toString());
    }

    /**
     * 公開URLをファイルに変更する
     * @param url URL
     * @return
     */
    public static File getPublicFileFromUrl(String url) {
        return new File(UString.build(getPhysicResourceLocation(), url.replaceAll("^" + EXTERNAL_RES_URL, UString.EMPTY)));
    }

    /**
     * 指定されたURL
     * @param directory
     * @return
     */
    public static StringBuilder getPublicUrlOf(String directory) {
        if(directory.endsWith("/"))
            return new StringBuilder(EXTERNAL_RES_URL).append(directory);
        return new StringBuilder(EXTERNAL_RES_URL).append(directory).append("/");
    }

    /**
     * 指定されたURL
     * @param directory
     * @return
     */
    public static StringBuilder getPublicTmpUrl() {
        return getPublicUrlOf("tmp");
    }
}