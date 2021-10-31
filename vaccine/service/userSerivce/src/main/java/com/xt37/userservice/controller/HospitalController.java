package com.xt37.userservice.controller;


import com.xt37.commentUtils.R;
import com.xt37.userservice.entity.Hospital;
import com.xt37.userservice.entity.User;
import com.xt37.userservice.service.HospitalService;
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
@RequestMapping("/userservice/hospital")
public class HospitalController {
    @Autowired
    private HospitalService hospitalService;

    @GetMapping("HospLogin")
    public R login(Hospital hospital) {
        Hospital login = hospitalService.login(hospital);
        if (login != null) {
            return R.ok();
        } else {
            return R.error();
        }
    }

    @PostMapping("HospRegist")
    public R regist(Hospital hospital) {
        boolean save = hospitalService.save(hospital);
        if (save) {
            return R.ok();
        } else {
            return R.error();
        }
    }

    @PostMapping("hospUpdate")
    public R hospUpdate(Hospital hospital) {
        boolean update = hospitalService.update(hospital, null);
        if (update) {
            return R.ok();
        } else {
            return R.error();
        }
    }

    @DeleteMapping("hostDelete")
    public R HostDelete(Hospital hospital) {
        boolean b = hospitalService.removeById(hospital);
        if (b) {
            return R.ok();
        } else {
            return R.error();
        }
    }








}

