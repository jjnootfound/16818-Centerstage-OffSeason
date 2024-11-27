package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.util.Range;

public class PIDController {
    private final double kp;
    private final double ki;
    private final double kd;
    private int target = 0;
    private int prevError = 0;
    private long prevMillis = 0;

    public PIDController (double kp, double ki, double kd) {
        this.kp = kp;
        this.ki = ki;
        this.kd = kd;
    }
    public void setTarget(int target) {
        this.target = target;
    }
    public double calculate(int measurement) {
        //P
        int error = target - measurement;

        double p = error * kp;

        //I
        long now = System.currentTimeMillis();
        double timeChange = (now - prevMillis);
        double i = (error * timeChange) * ki;

        //D
        double d = kd * (error - prevError) /timeChange; //la mini madreeeee
        prevMillis = now;
        prevError = error;

        double sum = Range.clip(p + i + d, -1, 1);
        return sum;
    }
}
