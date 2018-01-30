package robohawks.controllers;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

import robohawks.modules.base.GrabModule;
import robohawks.modules.base.HolonomicDriveModule;
import robohawks.modules.base.LiftModule;
import robohawks.modules.base.TurnModule;

@TeleOp(name = "ContestTeleopController", group = "Teleop")
public class ContestTeleOpController extends Controller{

    HolonomicDriveModule drive;
    DcMotor leftarm;
    DcMotor rightarm;

    @Override
    public void init() {
        drive = new HolonomicDriveModule(hardwareMap);
        leftarm = hardwareMap.dcMotor.get("leftarm");
        rightarm = hardwareMap.dcMotor.get("rightarm");
    }

    @Override
    public void loop() {
        super.loop();

        //Drive

        if (gamepad1.dpad_up){
            drive.setPowerOne(.5);
            drive.setPowerTwo(.5);
            drive.setPowerThree(.5);
            drive.setPowerFour(.5);
        } else if (gamepad1.dpad_down) {
            drive.setPowerOne(-.5);
            drive.setPowerTwo(-.5);
            drive.setPowerThree(-.5);
            drive.setPowerThree(-.5);
        } else if (gamepad1.dpad_left){
            drive.setPowerOne(.5);
            drive.setPowerTwo(-.5);
            drive.setPowerThree(-.5);
            drive.setPowerFour(.5);
        } else if (gamepad1.dpad_right){
            drive.setPowerOne(-.5);
            drive.setPowerTwo(.5);
            drive.setPowerThree(.5);
            drive.setPowerFour(-.5);
        } else {
            drive.setPowerOne(0);
            drive.setPowerTwo(0);
            drive.setPowerThree(0);
            drive.setPowerFour(0);
        }

        if(gamepad1.right_stick_x > 1){
            drive.setPowerOne(.5);
            drive.setPowerTwo(.5);
            drive.setPowerThree(.5);
            drive.setPowerFour(.5);
        } else if (gamepad1.right_stick_x < 0){
            drive.setPowerOne(-.5);
            drive.setPowerTwo(-.5);
            drive.setPowerThree(-.5);
            drive.setPowerFour(-.5);
        } else {
            drive.setPowerOne(0);
            drive.setPowerTwo(0);
            drive.setPowerThree(0);
            drive.setPowerFour(0);
        }

//        float gamepad1LeftY = gamepad1.left_stick_y;
//        float gamepad1LeftX = -gamepad1.left_stick_x;
//        float gamepad1RightX = -gamepad1.right_stick_x;
//
//        float FrontLeft = -gamepad1LeftY - gamepad1LeftX - gamepad1RightX;
//        float FrontRight = gamepad1LeftY - gamepad1LeftX - gamepad1RightX;
//        float BackRight = gamepad1LeftY + gamepad1LeftX - gamepad1RightX;
//        float BackLeft = -gamepad1LeftY + gamepad1LeftX - gamepad1RightX;
//
//        FrontRight = Range.clip(FrontRight, -1, 1);
//        FrontLeft = Range.clip(FrontLeft, -1, 1);
//        BackLeft = Range.clip(BackLeft, -1, 1);
//        BackRight = Range.clip(BackRight, -1, 1);
//
//        drive.setPowerTwo(FrontRight/2);
//        drive.setPowerOne(FrontLeft/2);
//        drive.setPowerThree(BackLeft/2);
//        drive.setPowerFour(BackRight/2);

        //Arm

        if (gamepad2.dpad_down){
            leftarm.setPower(.5);
            rightarm.setPower(.5);
        } else {
            leftarm.setPower(0);
            rightarm.setPower(0);
        }

        if (gamepad2.dpad_up){
            leftarm.setPower(-.5);
            rightarm.setPower(-.5);
        } else {
            leftarm.setPower(0);
            rightarm.setPower(0);
        }

    }

}
