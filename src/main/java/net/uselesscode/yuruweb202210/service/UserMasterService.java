package net.uselesscode.yuruweb202210.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import net.uselesscode.yuruweb202210.bean.UserBean;
import net.uselesscode.yuruweb202210.domain.UserMaster;
import net.uselesscode.yuruweb202210.domain.UserRoleMasterKey;
import net.uselesscode.yuruweb202210.mapper.UserMasterMapper;
import net.uselesscode.yuruweb202210.mapper.UserRoleMasterMapper;

@Service
public class UserMasterService {

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	private UserMasterMapper userMasterMapper;

	@Autowired
	private UserRoleMasterMapper userRoleMasterMapper;

	public List<UserBean> findAll() {
		List<UserMaster> users = userMasterMapper.selectByExample(null);
		List<UserBean> results = new ArrayList<>();
		users.forEach(user -> {
			UserBean result = new UserBean();
			BeanUtils.copyProperties(user, result);
			result.setPassword(null);
			results.add(result);
		});
		return results;
	}

	public void addUser(UserBean user) {
		UserMaster record = new UserMaster();
		BeanUtils.copyProperties(user, record);
		record.setPassword(passwordEncoder.encode(user.getPassword()));
		userMasterMapper.insert(record);

		UserRoleMasterKey userRole = new UserRoleMasterKey();
		userRole.setUserId(record.getId());
		userRole.setRoleId(2);
		userRoleMasterMapper.insert(userRole);
	}
}
