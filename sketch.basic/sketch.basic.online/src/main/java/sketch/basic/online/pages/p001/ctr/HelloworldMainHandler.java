package sketch.basic.online.pages.p001.ctr;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jp.gtf.kernel.lang.ui.ctrl.BaseH5PageHandler1;
import sketch.basic.online.pages.p001.obj.HelloworldMainDiv;

@RestController
@RequestMapping(value = "/hello")
public class HelloworldMainHandler extends BaseH5PageHandler1<HelloworldMainDiv> {

	@Override
	public void onLoad(HelloworldMainDiv data) {

	}

	@Override
	protected HelloworldMainDiv onBuild() {
		HelloworldMainDiv div = new HelloworldMainDiv();
		return div;
	}

}
