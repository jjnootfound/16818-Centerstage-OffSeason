package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous
public class AutonomousRedAudience extends LinearOpMode {
    private Drivetrain drivetrain;
    @Override
    public void runOpMode() throws InterruptedException {
        drivetrain = new Drivetrain(hardwareMap);

        waitForStart();
        drivetrain.drive(1, Math.PI/2, 0);
        sleep(540);

        drivetrain.stop();

        drivetrain.drive(0, 2 * Math.PI, -1);
        sleep(500);

        drivetrain.stop();

        drivetrain.drive(1,Math.PI/2,0);
        sleep(1450);

        drivetrain.stop();

        drivetrain.drive(0.5,11 * Math.PI/6,-0.5);
        sleep(500);

        drivetrain.stop();

        drivetrain.drive(1,Math.PI/2,0);
        sleep(470);

        drivetrain.stop();


    }
}