package Command;

import CommandReciver.Stereo;

/* OO命令模式——将“请求”封装成对象，
 * 以便使用不同的请求、队列或者日志来参数化其他对象。
 * 命令模式也支持可撤销的操作 */

/* 命令模式对象：
 * 它会将“具体的命令”stereo.off()封装成
 *“格式化的命令”Command.execute() */
public class StereoOffCommand implements Command {
    Stereo stereo;

    public StereoOffCommand(Stereo stereo) {
        this.stereo = stereo;
    }

    @Override
    public void execute() {
        stereo.off();
    }
}
