package com.example.attendance;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AttendanceController {

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @PostMapping("/calculate")
public String calculateAttendance(
        @RequestParam String studentName,
        @RequestParam int totalClasses,
        @RequestParam int attendedClasses,
        Model model) {

    if (totalClasses <= 0) {
        model.addAttribute("error", "Total classes must be greater than 0.");
        return "index";
    }

    if (attendedClasses < 0 || attendedClasses > totalClasses) {
        model.addAttribute("error",
                "Classes attended must be between 0 and total classes.");
        return "index";
    }

    double attendance = ((double) attendedClasses / totalClasses) * 100;

    String status;

    if (attendance >= 75) {
        status = "Eligible";
    } else {
        status = "Not Eligible";
    }

    model.addAttribute("studentName", studentName);
    model.addAttribute("totalClasses", totalClasses);
    model.addAttribute("attendedClasses", attendedClasses);
    model.addAttribute("attendance", String.format("%.2f", attendance));
    model.addAttribute("status", status);

    return "result";
}
}