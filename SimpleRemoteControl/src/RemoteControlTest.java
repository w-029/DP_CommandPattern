import Command.GarageDoorOpenCommand;
import Command.LightOnCommand;
import CommandReciver.GarageDoor;
import CommandReciver.Light;

/* 这是命令模式的客户，
 * 它负责使用“命令模式”类对象 */
public class RemoteControlTest {
    public static void main(String[] args) {

        /* 发出遥控命令的“单槽遥控器”，
         * 其“卡槽”用于安装具体的“命令接收者”*/
        SimpleRemoteControl remote = new SimpleRemoteControl();
        /* 具体的命令接收者 */
        Light light = new Light();
        /* 使用“命令模式”将具体的“命令格式化”，
         * 其超类接口指定了“格式化后的命令”名称execute() */
        LightOnCommand lightOn = new LightOnCommand(light);

        /* 再来一组命令接收者与命令对象 */
        GarageDoor door = new GarageDoor();
        GarageDoorOpenCommand doorOpen = new GarageDoorOpenCommand(door);

        /* 设置具体的“命令对象”lightOn */
        remote.setCommand(lightOn);
        /* 触发封装过的格式化命令 */
        remote.buttonWasPressed();

        /* 重置命令对象,并再次触发命令开关 */
        remote.setCommand(doorOpen);
        remote.buttonWasPressed();
    }
}
