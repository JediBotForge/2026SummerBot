package virtual_robot.robots.classes;

import com.qualcomm.robotcore.hardware.CRServoImpl;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorExImpl;
import com.qualcomm.robotcore.hardware.configuration.MotorType;

import virtual_robot.controller.BotConfig;
@BotConfig(name = "StarterBot Chassis", filename = "starterbot_chassis")
public class StarterBotChassisSim extends TwoWheelPhysicsBase {
    @Override
    protected void createHardwareMap() {
        super.createHardwareMap();

        hardwareMap.setActive(true);
        hardwareMap.put("left_drive", hardwareMap.get(DcMotorEx.class, "left_motor"));
        hardwareMap.put("right_drive", hardwareMap.get(DcMotorEx.class, "right_motor"));
        hardwareMap.setActive(false);

        hardwareMap.put("intake", new DcMotorExImpl(MotorType.Gobilda192, motorController1, 0));
        hardwareMap.put("left_intake_servo", new CRServoImpl(360));
        hardwareMap.put("right_intake_servo", new CRServoImpl(360));
    }
}
