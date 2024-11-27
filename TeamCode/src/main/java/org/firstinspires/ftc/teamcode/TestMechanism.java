package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class TestMechanism {

    private final DcMotor leftSlider;
    private final DcMotor rightSlider;

    public TestMechanism (HardwareMap hardwareMap) {
        leftSlider = hardwareMap.get(DcMotor.class, "leftSlider");
        rightSlider = hardwareMap.get(DcMotor.class,"rightSlider");
    }
    public void expandSliders() {
        leftSlider.setPower(0.5);
        rightSlider.setPower(-0.5);
    }
    public void contractSliders() {
        leftSlider.setPower(-1);
        rightSlider.setPower(1);
    }
    public void stopSliders() {
        leftSlider.setPower(0);
        rightSlider.setPower(0);
    }
}