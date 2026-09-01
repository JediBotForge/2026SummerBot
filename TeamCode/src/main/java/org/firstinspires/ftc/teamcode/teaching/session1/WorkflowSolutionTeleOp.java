package org.firstinspires.ftc.teamcode.teaching.session1;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "Teaching S1 Solution - Workflow", group = "Teaching S1")
public class WorkflowSolutionTeleOp extends OpMode {
    @Override
    public void init() {
        telemetry.addLine("Ready: INIT ran once.");
    }

    @Override
    public void loop() {
        telemetry.addData("A pressed", gamepad1.a);
        telemetry.addData("Left stick Y", "%.2f", gamepad1.left_stick_y);
        telemetry.addLine("START moved execution from init() to loop().");
    }
}
