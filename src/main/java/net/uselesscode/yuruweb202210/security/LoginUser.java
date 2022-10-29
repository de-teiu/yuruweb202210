package net.uselesscode.yuruweb202210.security;

import java.util.List;

public record LoginUser(Integer id, String name, String mail, String password, List<String> roles) {

}
