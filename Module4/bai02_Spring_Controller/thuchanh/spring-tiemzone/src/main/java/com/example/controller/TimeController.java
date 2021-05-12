package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.TimeZone;

@Controller
public class TimeController {
@GetMapping("/time")
    public String getTimeByTimeZone(Model model, @RequestParam(name = "city", required = false, defaultValue = "Asia/Ho_Chi_Minh" ) String city){
    //nhận thời gian hiện tại tại địa phương//
    Date date = new Date();
    //nhận múi giờ hiện tại tại địa phương//
    TimeZone timeZone = TimeZone.getDefault();
    //Nhận múi giờ theo thành phố được chỉ định//
    TimeZone time = TimeZone.getTimeZone(city);
    //Tính thời gian hiện tại ở thành phố được chỉ định//
    //getRawOffset()trả về lượng thời gian tính bằng mili giây//
    long locale_time = date.getTime()+(time.getRawOffset()-timeZone.getRawOffset());

    //Đặt lại ngày theo locale_time
    date.setTime(locale_time);
    model.addAttribute("city",city);
    model.addAttribute("date",date);
    model.addAttribute("locale_time",locale_time);


        return "index" ;
    }
}
