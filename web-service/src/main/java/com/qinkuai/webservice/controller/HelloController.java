package com.qinkuai.webservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @author QinKuai
 * 创建时间：2020年5月21日
 * 描述：
 * 只是一个页面跳转，没有任何业务逻辑
 * 用于测试新环境是否运作
 */
@Controller
public class HelloController {
	@RequestMapping("/hello")
	public String hello() {
		return "/hello";
	}
}
