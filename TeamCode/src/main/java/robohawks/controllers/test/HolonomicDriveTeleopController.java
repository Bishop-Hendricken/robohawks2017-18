package robohawks.controllers.test;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.Range;

import robohawks.async.Sequence;
import robohawks.async.error.ErrorArgs;
import robohawks.async.error.ErrorHandler;
import robohawks.controllers.old.TeleopController;
import robohawks.modules.base.HolonomicDriveModule;

/**
 * Created by Paarth Tandon on 10/6/2017.
 */

@TeleOp(name="HolonomicTeleop", group ="Teleop")
public class HolonomicDriveTeleopController extends TeleopController implements ErrorHandler{

    HolonomicDriveModule holonomicDriveModule;
    float threshold = .1f;

    @Override
    public void init() {
        holonomicDriveModule = new HolonomicDriveModule(hardwareMap);
    }

    @Override
    public void loop() {
        super.loop();

        // left stick controls direction
        // right stick X controls rotation

        float gamepad1LeftY = -gamepad1.left_stick_y;
        float gamepad1LeftX = gamepad1.left_stick_x;
        float gamepad1RightX = gamepad1.right_stick_x;

        // holonomic formulas

        float FrontLeft = -gamepad1LeftY - gamepad1LeftX - gamepad1RightX;
        float FrontRight = gamepad1LeftY - gamepad1LeftX - gamepad1RightX;
        float BackRight = gamepad1LeftY + gamepad1LeftX - gamepad1RightX;
        float BackLeft = -gamepad1LeftY + gamepad1LeftX - gamepad1RightX;

        // clip the right/left values so that the values never exceed +/- 1
        FrontRight = Range.clip(FrontRight, -1, 1);
        FrontLeft = Range.clip(FrontLeft, -1, 1);
        BackLeft = Range.clip(BackLeft, -1, 1);
        BackRight = Range.clip(BackRight, -1, 1);

        // write the values to the motors
        holonomicDriveModule.setPowerTwo(FrontRight);
        holonomicDriveModule.setPowerOne(FrontLeft);
        holonomicDriveModule.setPowerThree(BackLeft);
        holonomicDriveModule.setPowerFour(BackRight);
    }

    @Override
    public boolean buttonDown(int controller, int buttonCode) {
        return false;
    }

    @Override
    public boolean buttonUp(int controller, int buttonCode) {
        return false;
    }

    @Override
    public boolean joystickMoved(int controller, int joystickCode, float x, float y) {
        return false;
    }

    @Override
    public boolean triggerPressed(int controller, int triggerCode, float value) {
        return false;
    }

    @Override
    public void handleError(Sequence sequence, ErrorArgs error) {

    }
}
