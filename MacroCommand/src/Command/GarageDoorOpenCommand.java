package Command;

import CommandReciver.GarageDoor;

/* OO命令模式——将“请求”封装成对象，
 * 以便使用不同的请求、队列或者日志来参数化其他对象。
 * 命令模式也支持可撤销的操作 */

/* 命令模式对象：
 * 它会将“具体的命令”door.on()封装成
 *“格式化的命令”Command.execute() */
public class GarageDoorOpenCommand implements Command {

    GarageDoor door;

    public GarageDoorOpenCommand(GarageDoor door) {
        /* 构造函数里接收待格式化的“具体命令接收者” */
        this.door = door;
    }

    @Override
    public void execute() {
        /* 将具体的“命令接收者的功能格式化”为execute()方法 */
        door.open();
    }

    @Override
    public void undo() {
        door.close();
    }
}
