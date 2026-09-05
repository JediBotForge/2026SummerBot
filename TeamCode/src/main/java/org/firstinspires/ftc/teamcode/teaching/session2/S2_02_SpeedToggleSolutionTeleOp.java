package org.firstinspires.ftc.teamcode.teaching.session2;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "[S2-02] Speed toggle - Solution", group = "Teaching S2")
public class S2_02_SpeedToggleSolutionTeleOp extends OpMode {
    private static final double LESSON_SPEED = 0.5;
    private DcMotor lf, rf, lb, rb;
    private boolean slowMode;
    private boolean lastBumper;

    @Override
    public void init() {
        lf = hardwareMap.get(DcMotor.class, "left_front_drive");
        rf = hardwareMap.get(DcMotor.class, "right_front_drive");
        lb = hardwareMap.get(DcMotor.class, "left_back_drive");
        rb = hardwareMap.get(DcMotor.class, "right_back_drive");
        lf.setDirection(DcMotor.Direction.REVERSE);
        lb.setDirection(DcMotor.Direction.FORWARD);
        rb.setDirection(DcMotor.Direction.REVERSE);
        for (DcMotor motor : new DcMotor[] {lf, rf, lb, rb}) {
            motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        }
    }

    @Override
    public void loop() {
        boolean bumper = gamepad1.right_bumper;
        if (bumper && !lastBumper) {
            slowMode = !slowMode;
        }
        lastBumper = bumper;
        double speed = LESSON_SPEED * (slowMode ? 0.35 : 1.0);
        double forward = -gamepad1.left_stick_y;
        double turn = gamepad1.right_stick_x;
        setSide(speed * (forward + turn), lf, lb);
        setSide(speed * (forward - turn), rf, rb);
        telemetry.addData("Speed", slowMode ? "SLOW" : "FULL");
        telemetry.addLine("Tap right bumper once to toggle; hold does not repeat.");
    }

    private void setSide(double power, DcMotor front, DcMotor rear) {
        front.setPower(power);
        rear.setPower(power);
    }
}
