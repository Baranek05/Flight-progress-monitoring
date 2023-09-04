package com.example.server.session;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class SessionService {

    public Session getUserLoginTimes() {
        LocalDateTime loginTime = LocalDateTime.now();
        LocalDateTime breakStartTime = loginTime.plusHours(2);
        LocalDateTime breakEndTime = loginTime.plusHours(3);
        LocalDateTime shiftEndTime = loginTime.plusHours(5);

        Session userLoginTime = new Session();
        userLoginTime.setShiftStartTime(loginTime);
        userLoginTime.setBreakStartTime(breakStartTime);
        userLoginTime.setBreakEndTime(breakEndTime);
        userLoginTime.setShiftEndTime(shiftEndTime);

        return userLoginTime;
    }
}
