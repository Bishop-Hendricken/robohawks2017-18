package robohawks.controllers.test;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import robohawks.async.Sequence;
import robohawks.controllers.Controller;
import robohawks.modules.base.HolonomicDriveModule;

@TeleOp(name = "HolonomicDriveController", group = "Teleop")
public class HolonomicDriveController extends Controller{
    Sequence mainSequence;

    @Override
    public void init() {
        HolonomicDriveModule holonomicDriveModule = new HolonomicDriveModule(hardwareMap);
        mainSequence = sequencer.begin(holonomicDriveModule.holonomicDrive(5, 1, 1, 1, 1));
    }

    @Override
    public void loop() {
        super.loop();

        if(mainSequence.isFinished()) requestOpModeStop();
    }

}
