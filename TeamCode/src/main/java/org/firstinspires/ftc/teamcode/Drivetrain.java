package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Drivetrain {

    private final DcMotor frontLeft;
    private final DcMotor frontRight;

    private final DcMotor backLeft;

    private final DcMotor backRight;

    private void setMotorPowers(double frontLeftPower, double frontRightPower, double backLeftPower, double backRightPower) {
        frontLeft.setPower(frontLeftPower);
        frontRight.setPower(frontRightPower);
        backLeft.setPower(backLeftPower);
        backRight.setPower(backRightPower);
    }

    public Drivetrain(HardwareMap hardwareMap){
        frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");
        frontRight = hardwareMap.get(DcMotor.class, "frontRight");
        backLeft = hardwareMap.get(DcMotor.class, "backLeft");
        backRight = hardwareMap.get(DcMotor.class, "backRight");

        frontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeft.setDirection(DcMotorSimple.Direction.REVERSE);
    }
    public void drive(double vd, double td, double vt) {
        double sin, cos, max;
        double frontLeftPower, frontRightPower, backLeftPower, backRightPower;

        sin = Math.sin(td - Math.PI / 4);
        cos = Math.cos(td - Math.PI / 4);
        max = Math.max(Math.abs(sin), Math.abs(cos));

        frontLeftPower = vd * cos / max + vt;
        frontRightPower = vd * sin / max - vt;
        backLeftPower = vd * sin / max + vt;
        backRightPower = vd * cos / max - vt;

        if ((vd + Math.abs(vt)) > 1) {
            frontLeftPower /= vd + vt;
            frontRightPower /= vd + vt;
            backLeftPower /= vd + vt;
            backRightPower /= vd + vt;
        }
        setMotorPowers(frontLeftPower, frontRightPower, backLeftPower, backRightPower);
    }

    public void stop() {
        setMotorPowers(0,0,0,0);
    }
}
