package Command;

import CommandReciver.Stereo;

/* OO命令模式——将“请求”封装成对象，
 * 以便使用不同的请求、队列或者日志来参数化其他对象。
 * 命令模式也支持可撤销的操作 */

/* 命令模式对象：
 * 它会将具体的“命令组”统一封装成
 *“格式化的命令”Command.execute() */
public class StereoOnWithCDCommand implements Command {
    Stereo stereo;

    public StereoOnWithCDCommand(Stereo stereo) {
        this.stereo = stereo;
    }

    /* 注意：这里将一组命令封装为格式化的Command.execute()
     * 因为要完成播放CD立体声，必须执行这一连串动作，
     * 但经过“命令模式”封装之后，
     * 就只需要“一键操作”了 */
    @Override
    public void execute() {
        stereo.on();
        stereo.setCd();
        stereo.setVolume();
    }
}
