package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.opencv.core.Mat;

@Autonomous
public class AutonomousRedBackdrop extends LinearOpMode {
    private Drivetrain drivetrain;
    @Override
    public void runOpMode() throws InterruptedException {
        drivetrain = new Drivetrain(hardwareMap);

        waitForStart();
        drivetrain.drive(1, Math.PI/2, 0);
        sleep(560);

        drivetrain.stop();




    }
}
