package Command;

import CommandReciver.CeilingFan;

/* OO命令模式——将“请求”封装成对象，
 * 以便使用不同的请求、队列或者日志来参数化其他对象。
 * 命令模式也支持可撤销的操作 */

/* 命令模式对象：
 * 它会将“具体的命令”ceilingFan.off()封装成
 *“格式化的命令”Command.execute() */
public class CeilingFanOffCommand implements Command {
    CeilingFan ceilingFan;
    int prevSpeed;

    public CeilingFanOffCommand(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }

    @Override
    public void execute() {
        /* 先记录执行本次命令之前的“状态”，
         * 以便“撤销”本次命令时恢复到之前的状态 */
        prevSpeed = ceilingFan.getSpeed();
        /* 再执行本次命令 */
        ceilingFan.off();
    }

    @Override
    public void undo() {
        /* “本次命令”“之前的状态”就是其“撤销命令” */
        if (prevSpeed == ceilingFan.HIGH) {
            ceilingFan.high();
        } else if (prevSpeed == ceilingFan.MEDIUM) {
            ceilingFan.medium();
        } else if (prevSpeed == ceilingFan.LOW) {
            ceilingFan.low();
        }
        /* 注意：off也视为一种状态，于其他状态同等对待 */
        else if (prevSpeed == ceilingFan.OFF) {
            ceilingFan.off();
        }
    }
}
