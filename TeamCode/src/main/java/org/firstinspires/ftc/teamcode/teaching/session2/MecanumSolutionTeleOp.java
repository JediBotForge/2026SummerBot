package org.firstinspires.ftc.teamcode.teaching.session2;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import org.firstinspires.ftc.teamcode.HardwareMapUtil;

@TeleOp(name = "Teaching S2 Solution - Mecanum", group = "Teaching S2")
public class MecanumSolutionTeleOp extends OpMode {
    private DcMotor lf, rf, lb, rb;

    @Override
    public void init() {
        lf = hardwareMap.get(DcMotor.class, "left_front_drive");
        rf = hardwareMap.get(DcMotor.class, "right_front_drive");
        lb = hardwareMap.get(DcMotor.class, "left_back_drive");
        rb = hardwareMap.get(DcMotor.class, "right_back_drive");
        lf.setDirection(DcMotor.Direction.REVERSE);
        lb.setDirection(DcMotor.Direction.REVERSE);
        rf.setDirection(DcMotor.Direction.FORWARD);
        rb.setDirection(DcMotor.Direction.FORWARD);
        for (DcMotor motor : new DcMotor[] {lf, rf, lb, rb}) {
            motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        }
    }

    @Override
    public void loop() {
        double forward = HardwareMapUtil.forwardInput(gamepad1.left_stick_y);
        double strafe = gamepad1.left_stick_x;
        double rotate = gamepad1.right_stick_x;
        double denominator = Math.max(Math.abs(forward) + Math.abs(strafe) + Math.abs(rotate), 1.0);
        lf.setPower((forward + strafe + rotate) / denominator);
        rf.setPower((forward - strafe - rotate) / denominator);
        lb.setPower((forward - strafe + rotate) / denominator);
        rb.setPower((forward + strafe - rotate) / denominator);
        telemetry.addLine("Mecanum drive: forward, strafe, and turn");
    }
}
