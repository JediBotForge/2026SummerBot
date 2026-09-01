package org.firstinspires.ftc.teamcode.teaching.session1;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "Teaching S1 Exercise - Workflow", group = "Teaching S1")
public class WorkflowExerciseTeleOp extends OpMode {
    @Override
    public void init() {
        telemetry.addLine("Initialized. Press START, then read the loop telemetry.");
    }

    @Override
    public void loop() {
        telemetry.addData("Workflow", "This is an iterative init() + loop() OpMode");
        telemetry.addData("Gamepad", "A=%s  left stick Y=%.2f", gamepad1.a, gamepad1.left_stick_y);
    }
}
