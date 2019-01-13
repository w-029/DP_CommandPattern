import Command.Command;

/* 这是命令模式类（就像一个通用遥控器），
 * 它“只有一个命令槽”（就像是通用遥控器的卡槽），
 * 卡槽负责接收命令对象（不管是哪个具体命令对象），
 * 并将“格式化的操作动作”与具体的“命令对象功能”关联起来 */
public class SimpleRemoteControl {

    /*“格式化”后的“命令对象”
     * 这里只能接受一个命令对象 */
    Command slot;

    public SimpleRemoteControl() {}

    public void setCommand(Command command) {
        /* 将“命令对象”（以其格式化后的超类Command来统一类型）
         * 安装到具体的“卡槽”slot上，
         * 这里将“针对超类接口”Command来编程，
         * 而不管具体命令对象是什么 */
        slot = command;
    }

    public void buttonWasPressed() {
        /* 调用“格式化后的动作”execute()
         * 就是调用“具体命令接收者的某个功能”,
         * 具体是什么功能，要看setCommand()方法
         * 送进来的是Command接口的哪一个具体的子类对象，
         * 以及其被格式化的命令是什么 */
        /* 针对“命令对象的接口”编程，
         * 只管执行格式化后的execute()方法就行，
         * 不管具体被格式化的是哪个具体命令，
         * 这是“命令模式”的精髓 */
        slot.execute();
    }
}
