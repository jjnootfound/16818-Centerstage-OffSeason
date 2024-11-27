package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Outtake {
    private PIDController pid = null;
    private final DcMotor outtakeSliderLeft;
    private final DcMotor outtakeSliderRight;
    private final Servo rightServoArm;
    private final Servo leftServoArm;
    private final Servo servoWrist;
    private final Servo leftClaw;
    private final Servo rightClaw;
    private final Servo droneLauncher;

    private double wristPosition = 0.2;

    public Outtake(HardwareMap hardwareMap) {
        pid = new PIDController(0.5, 0, 0);
        outtakeSliderLeft = hardwareMap.get(DcMotor.class, "outtakeSliderLeft");
        outtakeSliderRight = hardwareMap.get(DcMotor.class, "outtakeSliderRight");
        rightServoArm = hardwareMap.get(Servo.class, "rightServoArm");
        leftServoArm = hardwareMap.get(Servo.class, "leftServoArm");
        servoWrist = hardwareMap.get(Servo.class, "servoWrist");
        leftClaw = hardwareMap.get(Servo.class, "leftClaw");
        rightClaw = hardwareMap.get(Servo.class, "rightClaw");
        droneLauncher = hardwareMap.get(Servo.class, "droneLauncher");
    }
    //Drone
    public void launchDrone() {
        droneLauncher.setPosition(0.2);
    }
    public void inlaunchDrone() {
        droneLauncher.setPosition(0) ;
    }
    //Sliders
    public void expandOuttakeSliders() {
        outtakeSliderLeft.setPower(0.7);
        outtakeSliderRight.setPower(-0.7);
    }
    public void contractOuttakeSliders() {
        outtakeSliderLeft.setPower(-0.7);
        outtakeSliderRight.setPower(0.7);
    }
    public void stopOuttakeSliders() {
        outtakeSliderLeft.setPower(0);
        outtakeSliderRight.setPower(0);
    }
    //Outtake Arm
    public void armInitialPosition() {
        leftServoArm.setPosition(1);
        rightServoArm.setPosition(0);
    }
    public void armBackdropPosition() {
        leftServoArm.setPosition(0);
        rightServoArm.setPosition(1);
    }
    public void armDroneLauncherPosition() {
        leftServoArm.setPosition(0.5);
        rightServoArm.setPosition(0.5);
    }
    //Wrist (unfinished!!!)
    public void wristInitialPosition() {
        servoWrist.setPosition(1);
    }
    public void wristBackdropPosition() {
        servoWrist.setPosition(0.7);
    }
    public void adjustWristPosition(double increment) {
        wristPosition += increment;
        wristPosition = Math.max(0, Math.min(wristPosition, 1));
        servoWrist.setPosition(wristPosition);
    }
    public double getWristPosition() {
        return wristPosition;
    }
    //Right Claw
    public void openRightClaw() {
        rightClaw.setPosition(0.09);
    }
    public void closeRightClaw() {
        rightClaw.setPosition(0.2);
    }
    //Left Claw
    public void openLeftClaw() {
        leftClaw.setPosition(0.1);
    }
    public void closeLeftClaw() {
        leftClaw.setPosition(0);
    }
    //PID Target
    public void setTarget(int target) {
        pid.setTarget(target);
        //int measurement
        //double power = pid.calculate(measurement);
    }
}
