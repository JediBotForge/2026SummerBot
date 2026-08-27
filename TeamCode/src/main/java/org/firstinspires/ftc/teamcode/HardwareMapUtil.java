package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.HardwareMap;

public final class HardwareMapUtil {
    private static final boolean SIMULATOR = isSimulator();

    private HardwareMapUtil() {
    }

    public static double forwardInput(double joystickY) {
        return SIMULATOR ? -joystickY : joystickY;
    }

    public static <T> T getOptional(
            HardwareMap hardwareMap, Class<? extends T> deviceType, String deviceName) {
        try {
            return hardwareMap.get(deviceType, deviceName);
        } catch (IllegalArgumentException ignored) {
            return null;
        }
    }

    private static boolean isSimulator() {
        try {
            Class.forName("virtual_robot.controller.VirtualRobotController");
            return true;
        } catch (ClassNotFoundException ignored) {
            return false;
        }
    }
}
