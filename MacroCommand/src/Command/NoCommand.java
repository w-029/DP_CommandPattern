package Command;

/* 这个命令模式类什么也不做，
 * 用于命令类对象的初始化（既不on也不off） */
public class NoCommand implements Command {

    @Override
    public void execute() {}

    @Override
    public void undo() {

    }
}
