package cn.e3mall.portal.controller;

import org.springframework.stereotype.Controller;
/**
 * 首页展示controller
 * Controller:控制器。对应的是类。
 * handler:处理器，对应的方法。
 * @author yang
 *
 */
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class IndexController {
	
	/**目的：浏览器输入ip+端口就可以访问到项目，
	 * 已知：spring拦截器的拦截规则是.html
	 * 解决方法：
	 * 		在web.xml中配置欢迎页， 使用，index.html。
	 * 浏览器发来请求，因为欢迎页，回去 webapp下找index.html。 找不到就会去 servlet中寻找，这时就会被前端控制器拦截。
	 * 然后转发到Controller。 请求的全称是 index.html。这里的　.html 可以省略。
	 * 
	 * return index ; 表示。转发到jsp页面。因为视图解析器的存在，不用写全路径，不然要写webapp下的路径 webapp用 /表示。
	 * 
	 * @return
	 */
	@RequestMapping("index")
	public String showIndex(){
		return "index";
	}
}
