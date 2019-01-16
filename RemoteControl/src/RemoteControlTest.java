import Command.*;
import CommandReciver.GarageDoor;
import CommandReciver.Light;
import CommandReciver.Stereo;

/* 这是命令模式的客户，
 * 它负责使用“命令模式”类对象 */
public class RemoteControlTest {
    public static void main(String[] args) {

        /* 发出遥控命令的“单槽遥控器”，
         * 其“每对卡槽”用于安装具体的“命令接收者”*/
        RemoteControl remoteControl = new RemoteControl();
        /* 具体的命令接收者 */
        Light light = new Light();
        /* 使用“命令模式”将具体的“命令格式化”，
         * 其超类接口指定了“封装后的格式化命令”名称execute() */
        LightOnCommand lightOn = new LightOnCommand(light);
        LightOffCommand lightOff = new LightOffCommand(light);

        /* 再来一组命令接收者与命令对象 */
        GarageDoor door = new GarageDoor();
        GarageDoorOpenCommand doorOpen = new GarageDoorOpenCommand(door);
        GarageDoorCloseCommand doorClose = new GarageDoorCloseCommand(door);

        /* 第三组命令接收者与命令对象 */
        Stereo stereo = new Stereo();
        StereoOnWithCDCommand stereoOnWithCD = new StereoOnWithCDCommand(stereo);
        StereoOffCommand stereoOff = new StereoOffCommand(stereo);

        /* 设置具体的“命令对象”lightOn，lightOff，与安装它们的卡槽位置slot */
        remoteControl.setCommand(0, lightOn, lightOff);
        /* 这里是发出命令的“动作”，
         * 响应是Command.execute()格式化命令
         * 具体执行的是被封装在execute()里面的一个/一组命令 */
        remoteControl.onButtonWasPressed(0);
        remoteControl.offButtonWasPressed(0);
        System.out.println();

        /* 设置第二对命令对象,并再次触发命令开、关 */
        remoteControl.setCommand(1, doorOpen, doorClose);
        remoteControl.onButtonWasPressed(1);
        remoteControl.offButtonWasPressed(1);
        System.out.println();

        /* 设置第三对命令对象,并再次触发命令开、关 */
        remoteControl.setCommand(2, stereoOnWithCD, stereoOff);
        remoteControl.onButtonWasPressed(2);
        remoteControl.offButtonWasPressed(2);
        System.out.println();
    }
}
