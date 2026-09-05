package virtual_robot.robots.classes;

import com.qualcomm.robotcore.hardware.CRServoImpl;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorExImpl;

import virtual_robot.controller.BotConfig;
@BotConfig(name = "Stryker: StarterBot", filename = "starterbot")
public class StarterBotMecanumSim extends MecanumPhysicsBase {
    @Override
    protected boolean isWheelMechanicallyReversed(int wheelIndex) {
        return wheelIndex == 0 || wheelIndex == 3;
    }

    @Override
    protected void createHardwareMap() {
        super.createHardwareMap();

        hardwareMap.setActive(true);
        hardwareMap.put("left_front_drive", hardwareMap.get(DcMotorEx.class, "front_left_motor"));
        hardwareMap.put("right_front_drive", hardwareMap.get(DcMotorEx.class, "front_right_motor"));
        hardwareMap.put("left_back_drive", hardwareMap.get(DcMotorEx.class, "back_left_motor"));
        hardwareMap.put("right_back_drive", hardwareMap.get(DcMotorEx.class, "back_right_motor"));
        hardwareMap.setActive(false);

        hardwareMap.put("intake", new DcMotorExImpl(MOTOR_TYPE, motorController1, 0));
        hardwareMap.put("left_intake_servo", new CRServoImpl(360));
        hardwareMap.put("right_intake_servo", new CRServoImpl(360));
    }
}
