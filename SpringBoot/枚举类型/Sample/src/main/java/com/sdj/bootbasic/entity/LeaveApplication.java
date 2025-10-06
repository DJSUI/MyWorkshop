package com.sdj.bootbasic.entity;

import com.sdj.bootbasic.common.LeaveStatus;
import org.springframework.stereotype.Component;


@Component
public class LeaveApplication {
    private String applicant;
    private LeaveStatus status;

    // 构造函数、getter 和 setter 方法
    public LeaveApplication() {}
    // 构造函数、getter 和 setter 方法
    public LeaveApplication(String applicant, LeaveStatus status) {
        this.applicant = applicant;
        this.status = status;
    }

    public String getApplicant() {
        return applicant;
    }

    public void setApplicant(String applicant) {
        this.applicant = applicant;
    }

    public LeaveStatus getStatus() {
        return status;
    }

    public void setStatus(LeaveStatus status) {
        this.status = status;
    }
}
