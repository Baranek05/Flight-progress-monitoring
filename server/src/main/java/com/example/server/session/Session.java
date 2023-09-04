package com.example.server.session;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Session {
    private LocalDateTime shiftStartTime;
    private LocalDateTime breakStartTime;
    private LocalDateTime breakEndTime;
    private LocalDateTime shiftEndTime;
}
