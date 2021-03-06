package cn.e3mall.portal.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
/**
 * 首页展示controller
 * Controller:控制器。对应的是类。
 * handler:处理器，对应的方法。
 * @author yang
 *
 */
import org.springframework.web.bind.annotation.RequestMapping;

import cn.e3mall.content.service.ContentService;
import cn.e3mall.pojo.TbContent;
@Controller
public class IndexController {
	@Value("${CONTENT_LUNBO_CID}")
	private Long CONTENT_LUNBO_CID;
	
	@Resource
	private ContentService contentService;
	
	
	/**目的：浏览器输入ip+端口就可以访问到项目，
	 * 已知：spring拦截器的拦截规则是.html
	 * 解决方法：
	 * 		在web.xml中配置欢迎页， 使用，index.html。
	 * 浏览器发来请求，因为欢迎页，回去 webapp下找index.html。 找不到就会去 servlet中寻找，这时就会被前端控制器拦截。
	 * 然后转发到Controller。 请求的全称是 index.html。这里的　.html 可以省略。
	 * 
	 * return index ; 表示。转发到jsp页面。因为视图解析器的存在，不用写全路径，不然要写webapp下的路径 webapp用 /表示。
	 * 
	 * @returnpr
	 */
	@RequestMapping("index")
	public String showIndex(Model model){
		/*
		 * 添加轮播图。
		 * 1，引入model
		 * 2.设置默认菜单id CONTENT_LUNBO_CID = 89
		 * 		在conf/resource.properties中设置参数，在springmvc.xml文件读取 ，加载。 placeholder 这个参数在spring.xml只能用一次。就是说只能加载一个配置文件。
		 * 		在Controller中使用参数 。 @Value("${参数名}")
		 * 
		 * 3. 将取到的list作为model的属性传入前端页面。
		 */
		
		 List<TbContent> ad1List = contentService.getTbContentByCid(CONTENT_LUNBO_CID);
		 model.addAttribute("ad1List", ad1List);
		 
		return "index";
	}
}
