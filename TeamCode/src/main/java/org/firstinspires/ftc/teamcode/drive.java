package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp
public class drive extends LinearOpMode {
    private DcMotor frontLeft, frontRight, backLeft, backRight;

    @Override
    public void runOpMode() {
        frontLeft = hardwareMap.get(DcMotor.class, "leftFront");
        frontRight = hardwareMap.get(DcMotor.class, "rightFront");
        backLeft = hardwareMap.get(DcMotor.class, "leftRear");
        backRight = hardwareMap.get(DcMotor.class, "rightRear");

        frontLeft.setDirection(DcMotorSimple.Direction.FORWARD);
        backLeft.setDirection(DcMotorSimple.Direction.FORWARD);
        frontRight.setDirection(DcMotorSimple.Direction.REVERSE);
        backRight.setDirection(DcMotorSimple.Direction.REVERSE);

        waitForStart();

        while (opModeIsActive()) {
            double y = gamepad1.left_stick_y;
            double x = -gamepad1.left_stick_x;
            double denominator = Math.max(Math.abs(x) + Math.abs(y), 1);

            // fata-spate, stanga-dreapta
            frontRight.setPower((y - x) / denominator);
            frontLeft.setPower((y + x) / denominator);
            backLeft.setPower((y - x) / denominator);
            backRight.setPower((y + x) / denominator);

            telemetry.addData("FR Power", frontRight.getPower());
            telemetry.addData("FL Power", frontLeft.getPower());
            telemetry.addData("BR Power", backRight.getPower());
            telemetry.addData("BL Power", backLeft.getPower());
        }
    }



}
