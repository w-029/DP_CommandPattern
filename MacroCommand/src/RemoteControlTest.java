import Command.Command;
import Command.LightOnCommand;
import Command.LightOffCommand;
import Command.GarageDoorOpenCommand;
import Command.GarageDoorCloseCommand;
import CommandReciver.GarageDoor;
import CommandReciver.Light;

/* 这是命令模式类（就像一个通用遥控器），
 * 它“有两组命令槽”（就像是通用遥控器的卡槽），
 * 卡槽负责接收命令对象（不管是哪个具体命令对象），
 * 并将“格式化的操作动作”与具体的“命令对象功能”关联起来 */
public class RemoteControlTest {
    public static void main(String[] args) {

        /* 具体命令的接收者 */
        Light light = new Light();
        GarageDoor door = new GarageDoor();

        /*“格式化”后的“命令对象”
         * 每个命令对象都有反操作命令对象 */
        LightOnCommand lightOn = new LightOnCommand(light);
        GarageDoorOpenCommand doorOpen = new GarageDoorOpenCommand(door);

        LightOffCommand lightOff = new LightOffCommand(light);
        GarageDoorCloseCommand doorClose = new GarageDoorCloseCommand(door);

        /* 放入命令组 */
        Command[] partyOn = {lightOn, doorOpen};
        Command[] partyOff = {lightOff, doorClose};

        /* 创建两个持有命令组的“宏命令” */
        MacroCommand partyOnMacro = new MacroCommand(partyOn);
        MacroCommand partyOffMacro = new MacroCommand(partyOff);

        /* 将一对宏命令指定给一组按键 */
        RemoteControlWithMacro remoteControlWithMacro = new RemoteControlWithMacro();
        remoteControlWithMacro.setCommand(0, partyOnMacro, partyOffMacro);

        /* 按键执行一组命令 */
        remoteControlWithMacro.onButtonWasPressed(0);
        System.out.println();
        remoteControlWithMacro.offButtonWasPressed(0);
        System.out.println();
        remoteControlWithMacro.undoButtonWasPressed();
        System.out.println();
        remoteControlWithMacro.offButtonWasPressed(0);
        System.out.println();
        remoteControlWithMacro.undoButtonWasPressed();
        System.out.println();
        remoteControlWithMacro.undoButtonWasPressed();
        System.out.println();
        remoteControlWithMacro.undoButtonWasPressed();
    }
}
