package robohawks.controllers;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

import robohawks.modules.base.HolonomicDriveModule;

/**
 * Created by Paarth Tandon on 1/3/2018.
 */

@Autonomous(name = "ContestAutonomousController")
public class ContestAutoController extends LinearOpMode {

    private ElapsedTime runtime = new ElapsedTime();
    private HolonomicDriveModule drive;
    private DcMotor arm;
    private CRServo leftServo;
    private Servo rightServo;


    @Override
    public void runOpMode() throws InterruptedException {

        telemetry.addData("STATUS", "OPMODESTART");
        telemetry.update();

        telemetry.addData("STATUS", "INITSTART");
        telemetry.update();

        drive = new HolonomicDriveModule(hardwareMap);
        arm = hardwareMap.dcMotor.get("arm");
        leftServo = hardwareMap.crservo.get("left");
        rightServo = hardwareMap.servo.get("right");

        telemetry.addData("STATUS", "INITEND");
        telemetry.update();

        waitForStart();
        runtime.reset();

        while(opModeIsActive()){
            rightServo.setPosition(.2);
            leftServo.setPower(1);

            break;
        }

        runtime.reset();

        while(opModeIsActive() && runtime.seconds() <= 2) {

            float gamepad1LeftY = 1;
            float gamepad1LeftX = -1;
            float gamepad1RightX = -1;

            float FrontLeft = .8f;
            float FrontRight = -1;
            float BackRight = -.8f;
            float BackLeft = .8f;

            FrontRight = Range.clip(FrontRight, -1, 1);
            FrontLeft = Range.clip(FrontLeft, -1, 1);
            BackLeft = Range.clip(BackLeft, -1, 1);
            BackRight = Range.clip(BackRight, -1, 1);

            drive.setPowerTwo(FrontRight/2);
            drive.setPowerOne(FrontLeft/2);
            drive.setPowerThree(BackLeft/2);
            drive.setPowerFour(BackRight/2);

            //drive.holonomicDrive(3, FrontLeft / 2, FrontRight / 2, BackLeft / 2, BackRight / 2);

            telemetry.addData("STATUS", "OPMODEEND");
            telemetry.update();

        }

        runtime.reset();

        while(opModeIsActive() && runtime.seconds() <= .75){

            telemetry.addData("STATUS", "OPMODESTART");
            telemetry.update();

            float FrontLeft = -1f;
            float FrontRight = -1f;
            float BackRight = -1f;
            float BackLeft = -1f;

            FrontRight = Range.clip(FrontRight, -1, 1);
            FrontLeft = Range.clip(FrontLeft, -1, 1);
            BackLeft = Range.clip(BackLeft, -1, 1);
            BackRight = Range.clip(BackRight, -1, 1);

            drive.setPowerTwo(FrontRight/2);
            drive.setPowerOne(FrontLeft/2);
            drive.setPowerThree(BackLeft/2);
            drive.setPowerFour(BackRight/2);

            //drive.holonomicDrive(3, FrontLeft / 2, FrontRight / 2, BackLeft / 2, BackRight / 2);

            telemetry.addData("STATUS", "OPMODEEND");
            telemetry.update();
        }

        runtime.reset();

        while(opModeIsActive() && runtime.seconds() <= 4.1) {

            float gamepad1LeftY = 1;
            float gamepad1LeftX = -1;
            float gamepad1RightX = -1;

            float FrontLeft = .8f;
            float FrontRight = -1;
            float BackRight = -.8f;
            float BackLeft = .8f;

            FrontRight = Range.clip(FrontRight, -1, 1);
            FrontLeft = Range.clip(FrontLeft, -1, 1);
            BackLeft = Range.clip(BackLeft, -1, 1);
            BackRight = Range.clip(BackRight, -1, 1);

            drive.setPowerTwo(FrontRight/2);
            drive.setPowerOne(FrontLeft/2);
            drive.setPowerThree(BackLeft/2);
            drive.setPowerFour(BackRight/2);

            //drive.holonomicDrive(3, FrontLeft / 2, FrontRight / 2, BackLeft / 2, BackRight / 2);

            telemetry.addData("STATUS", "OPMODEEND");
            telemetry.update();

        }
    }

}
