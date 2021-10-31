package com.xt37.userservice.controller;


import com.xt37.commentUtils.R;
import com.xt37.userservice.entity.User;
import com.xt37.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author xt37
 * @since 2021-09-18
 */
@RestController
@RequestMapping("/userservice/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("userLogin")
    public R login() {
        return R.ok().data("token","admin");
    }

    @PostMapping("userRegist")
    public R regist(User user) {
        User regist = userService.regist(user);
        if (regist == null) {
            return R.ok();
        } else {
            return R.error();
        }
    }

    @PostMapping("userUpdate")
    public R userUpdate(User user) {
        boolean update = userService.update(user, null);
        return R.ok();
    }

    @DeleteMapping("UserDelete")
    public R UserDelete(User user) {
        boolean b = userService.removeById(user.getUserid());
        if (b) {
            return R.ok();
        } else {
            return R.error();
        }
    }

}

