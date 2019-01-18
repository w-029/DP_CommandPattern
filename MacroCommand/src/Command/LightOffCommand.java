package Command;

import CommandReciver.Light;

/* OO命令模式——将“请求”封装成对象，
 * 以便使用不同的请求、队列或者日志来参数化其他对象。
 * 命令模式也支持可撤销的操作 */

/* 命令模式对象：
 * 它会将“具体的命令”light.off()封装成
 *“格式化的命令”Command.execute() */
public class LightOffCommand implements Command {
    Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.off();
    }

    @Override
    public void undo() {
        light.on();
    }
}
