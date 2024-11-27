package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Intake {
    private final DcMotor intakeSliderLeft;
    private final DcMotor intakeSliderRight;
    private final CRServo intakeRollers;
    private final Servo intakeCover;

    public Intake (HardwareMap hardwareMap) {
        intakeSliderLeft = hardwareMap.get(DcMotor.class, "intakeSliderLeft");
        intakeSliderRight = hardwareMap.get(DcMotor.class, "intakeSliderRight");
        intakeRollers = hardwareMap.get(CRServo.class, "intakeRollers");
        intakeCover = hardwareMap.get(Servo.class, "intakeCover");
    }

    public void setSlideMode(DcMotor.RunMode runMode) {
        intakeSliderLeft.setMode(runMode);
        intakeSliderRight.setMode(runMode);
    }

    //Rollers
    public void moveRollersInward() {
        intakeRollers.setPower(1);
    }
    public void moveRollersOutward() {
        intakeRollers.setPower(-1);
    }
    public void stopRollers() {
        intakeRollers.setPower(0);
    }
    //Sliders
    public void expandIntakeSliders() {
        intakeSliderLeft.setPower(0.5);
        intakeSliderRight.setPower(-0.5);
    }
    public void contractIntakeSliders() {
        if(intakeSliderLeft.getCurrentPosition() < 0){
            intakeSliderLeft.setPower(-0.5);
            intakeSliderRight.setPower(0.5);
        }
        else{
            intakeSliderLeft.setPower(0);
            intakeSliderRight.setPower(0);
        }
    }
    /*public void contractIntakeSlidersNoLimit() {
        intakeSliderLeft.setPower(-1);
        intakeSliderRight.setPower(1);
    }
    */

    public void stopIntakeSliders() {
        intakeSliderLeft.setPower(0);
        intakeSliderRight.setPower(0);
    }
    //Pixel Cover
    public void coverPixels () {
        intakeCover.setPosition(.8);
    }
    public void uncoverPixels () {
        intakeCover.setPosition(0.37);
    }
}
