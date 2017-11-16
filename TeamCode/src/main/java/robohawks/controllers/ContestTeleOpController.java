package robohawks.controllers;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.Range;

import robohawks.modules.base.GrabModule;
import robohawks.modules.base.HolonomicDriveModule;
import robohawks.modules.base.LiftModule;
import robohawks.modules.base.TurnModule;

@TeleOp(name = "Contest", group = "Teleop")
public class ContestTeleOpController extends Controller{

    HolonomicDriveModule drive;
    LiftModule arm;
    GrabModule grab;
    TurnModule turn;

    @Override
    public void init() {
        drive = new HolonomicDriveModule(hardwareMap);
        arm = new LiftModule(hardwareMap);
        grab = new GrabModule(hardwareMap);
        turn = new TurnModule(hardwareMap);

        grab.setLeftServo(.5);
        grab.setRightServo(.5);
    }

    @Override
    public void loop() {
        super.loop();

        //Drive

        float gamepad1LeftY = -gamepad1.left_stick_y;
        float gamepad1LeftX = gamepad1.left_stick_x;
        float gamepad1RightX = gamepad1.right_stick_x;

        float FrontLeft = -gamepad1LeftY - gamepad1LeftX - gamepad1RightX;
        float FrontRight = gamepad1LeftY - gamepad1LeftX - gamepad1RightX;
        float BackRight = gamepad1LeftY + gamepad1LeftX - gamepad1RightX;
        float BackLeft = -gamepad1LeftY + gamepad1LeftX - gamepad1RightX;

        FrontRight = Range.clip(FrontRight, -1, 1);
        FrontLeft = Range.clip(FrontLeft, -1, 1);
        BackLeft = Range.clip(BackLeft, -1, 1);
        BackRight = Range.clip(BackRight, -1, 1);

        drive.setPowerTwo(FrontRight/2);
        drive.setPowerOne(FrontLeft/2);
        drive.setPowerThree(BackLeft/2);
        drive.setPowerFour(BackRight/2);

        //Arm

        if (gamepad2.dpad_up){
            arm.setPower(.5);
        } else {
            arm.setPower(0);
        }

        if (gamepad2.dpad_down){
            arm.setPower(-.5);
        } else {
            arm.setPower(0);
        }

        //Grab

        if (gamepad2.a){
            grab.setLeftServo(1);
            grab.setRightServo(1);
        }

        if (gamepad2.b){
            grab.setLeftServo(.5);
            grab.setRightServo(.5);
        }

        //Turn

        if (gamepad2.dpad_right){
            turn.setTurn(.5);
        } else {
            turn.setTurn(0);
        }

        if (gamepad2.dpad_left){
            turn.setTurn(-.5);
        } else {
            turn.setTurn(0);
        }

    }

}
