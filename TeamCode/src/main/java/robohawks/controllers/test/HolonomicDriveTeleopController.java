package robohawks.controllers.test;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

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

        if (Math.abs(gamepad1.left_stick_x) > threshold){
            holonomicDriveModule.setPowerOne(gamepad1.left_stick_x);
            holonomicDriveModule.setPowerTwo(gamepad1.left_stick_x);
            holonomicDriveModule.setPowerThree(gamepad1.left_stick_x);
            holonomicDriveModule.setPowerFour(gamepad1.left_stick_x);
        }

        if (Math.abs(gamepad1.right_stick_y) > threshold){
            holonomicDriveModule.setPowerOne(gamepad1.left_stick_x);
            holonomicDriveModule.setPowerTwo(-1 * gamepad1.left_stick_x);
            holonomicDriveModule.setPowerThree(gamepad1.left_stick_x);
            holonomicDriveModule.setPowerFour(-1 * gamepad1.left_stick_x);
        }
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
