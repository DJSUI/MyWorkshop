package com.sdj.bootbasic.service;

import com.sdj.bootbasic.common.LeaveStatus;
import com.sdj.bootbasic.entity.LeaveApplication;
import org.springframework.stereotype.Service;

@Service
public class LeaveService {
    public void processLeaveApplication(LeaveApplication leaveApplication) {
        LeaveStatus status = leaveApplication.getStatus();
        switch (status) {
            case PENDING:
                // 处理待审批的逻辑
                System.out.println("处理待审批的请假申请");
                break;
            case APPROVED:
                // 处理已批准的逻辑
                System.out.println("处理已批准的请假申请");
                break;
            case REJECTED:
                // 处理已拒绝的逻辑
                System.out.println("处理已拒绝的请假申请");
                break;
            case CANCELLED:
                // 处理已取消的逻辑
                System.out.println("处理已取消的请假申请");
                break;
        }
    }
}
