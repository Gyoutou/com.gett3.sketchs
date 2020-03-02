package sketch.basic.online.pages.p001.ctr;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.gtf.spring.online.BasePresent1;
import sketch.basic.online.pages.p001.obj.HelloworldMainDiv;

@Controller
@RequestMapping(value = "/hello")
public class HelloworldMainView extends BasePresent1<HelloworldMainDiv> {

	@Override
	public Class<? extends HelloworldMainDiv> getType() {
		return HelloworldMainDiv.class;
	}

}
