package net.uselesscode.yuruweb202210.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import net.uselesscode.yuruweb202210.bean.UserBean;
import net.uselesscode.yuruweb202210.service.UserMasterService;

@Controller
@RequestMapping("/admin/master/user")
public class UserController {

	@Autowired
	private UserMasterService userMasterService;

	// ユーザー登録画面を表示
	@GetMapping("")
	public String index() {
		return "admin/master/user";
	}

	@GetMapping("/search")
	@ResponseBody
	public List<UserBean> search() {
		return userMasterService.findAll();
	}

	@PostMapping("/add")
	@ResponseBody
	public void add(@RequestBody @Validated UserBean user, BindingResult result) {
		if (result.hasErrors()) {
			throw new RuntimeException("入力エラー");
		}
		userMasterService.addUser(user);
	}
}
