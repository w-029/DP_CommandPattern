import Command.*;
import CommandReciver.CeilingFan;
import CommandReciver.Light;

/* 这是命令模式的客户，
 * 它负责使用“命令模式”类对象 */
public class RemoteControlTest {
    public static void main(String[] args) {

        /* 发出遥控命令的“单槽遥控器”，
         * 其“每对卡槽”用于安装具体的“命令接收者”*/
        RemoteControlWithUndo remoteControl = new RemoteControlWithUndo();


        /* 具体的命令接收者 */
        Light light = new Light();
        /* 使用“命令模式”将具体的“命令格式化”，
         * 其超类接口指定了“封装后的格式化命令”名称execute()、undo() */
        LightOnCommand lightOn = new LightOnCommand(light);
        LightOffCommand lightOff = new LightOffCommand(light);

        /* 一对一可逆操作命令的“撤销”操作 */
        remoteControl.setCommand(0, lightOn, lightOff);

        remoteControl.onButtonWasPressed(0);
        remoteControl.offButtonWasPressed(0);
        remoteControl.undoButtonWasPressed();
        remoteControl.offButtonWasPressed(0);
        remoteControl.onButtonWasPressed(0);
        remoteControl.undoButtonWasPressed();
        System.out.println();


        /* 多状态命令利用记录“之前状态”来实现“撤销”操作 */
        CeilingFan ceilingFan = new CeilingFan("Living Room");
        CeilingFanHightCommand ceilingFanHight = new CeilingFanHightCommand(ceilingFan);
        CeilingFanMediumCommand ceilingFanMedium = new CeilingFanMediumCommand(ceilingFan);
        CeilingFanLowCommand ceilingFanLow = new CeilingFanLowCommand(ceilingFan);
        CeilingFanOffCommand ceilingFanOff = new CeilingFanOffCommand(ceilingFan);

        remoteControl.setCommand(1, ceilingFanHight, ceilingFanOff);
        remoteControl.setCommand(2, ceilingFanMedium, ceilingFanOff);
        remoteControl.setCommand(3, ceilingFanLow, ceilingFanOff);

        remoteControl.onButtonWasPressed(2);
        remoteControl.offButtonWasPressed(2);
        remoteControl.undoButtonWasPressed();
        remoteControl.offButtonWasPressed(1);
        remoteControl.undoButtonWasPressed();
    }
}
