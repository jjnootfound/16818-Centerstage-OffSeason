package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class HBOffSeasonTeleOp extends OpMode {
    private Drivetrain drivetrain;
    private Intake intake;
    private Outtake outtake;

    @Override
    public void init() {
        drivetrain = new Drivetrain(hardwareMap);
        intake = new Intake(hardwareMap);
        outtake = new Outtake(hardwareMap);
    }

    @Override
    public void loop() {
        //drivetrain
        double x = gamepad1.left_stick_x;
        double y = -gamepad1.left_stick_y;
        double turn = gamepad1.right_stick_x;

        double vd = Math.hypot(x, y);
        double td = Math.atan2(y, x);

        drivetrain.drive(vd, td, turn * 0.6);
        //intake sliders
        if(gamepad1.right_bumper) {
            intake.expandIntakeSliders();
        }
        else if(gamepad1.left_bumper) {
            intake.contractIntakeSliders();
        }
        else {
            intake.stopIntakeSliders();
        }
        //intake rollers
        if(gamepad1.dpad_up) {
            intake.moveRollersOutward();
        }
        else if (gamepad1.dpad_down) {
            intake.moveRollersInward();
        }
        else {
            intake.stopRollers();
        }
        //intake pixel cover
        if(gamepad1.square) {
            intake.coverPixels();
        }
        else if(gamepad1.circle) {
            intake.uncoverPixels();
        }
        //outtake sliders
        if(gamepad2.right_bumper) {
            outtake.expandOuttakeSliders();
        }
        else if(gamepad2.left_bumper) {
            outtake.contractOuttakeSliders();
        }
        else {
            outtake.stopOuttakeSliders();
        }
        //outtake arm
        if(gamepad2.square) {
            outtake.armInitialPosition();
        }
        else if(gamepad2.triangle) {
            outtake.armBackdropPosition();
        }
        else if(gamepad2.circle) {
            outtake.armDroneLauncherPosition();
        }
        //outtake wrist
        if(gamepad2.left_trigger > 1) {
            outtake.wristInitialPosition();
        }
        else if(gamepad2.right_trigger > 1) {
            outtake.wristBackdropPosition();
        }
    }
}
