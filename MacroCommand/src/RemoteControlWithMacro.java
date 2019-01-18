import Command.NoCommand;

/* 这是命令模式类（就像一个通用遥控器），
 * 它“有两组命令槽”（就像是通用遥控器的卡槽），
 * 卡槽负责接收命令对象（不管是哪个具体命令对象），
 * 并将“格式化的操作动作”与具体的“命令对象功能”关联起来 */
public class RemoteControlWithMacro {

    /*“格式化”后的“命令对象”
     * 每个命令对象都有反操作命令对象 */
    MacroCommand[] partyOnMacros;
    MacroCommand[] partyOffMacros;
    MacroCommand undoMacro;

    public RemoteControlWithMacro() {
        NoCommand noCommand = new NoCommand();
        NoCommand[] noCommands = {noCommand};
        MacroCommand noMacroCommand = new MacroCommand(noCommands);

        partyOnMacros = new MacroCommand[7];
        partyOffMacros = new MacroCommand[7];

        for (int i = 0; i < 7; i++) {
            partyOnMacros[i] = noMacroCommand;
            partyOffMacros[i] = noMacroCommand;
        }
        undoMacro = noMacroCommand;
    }

    public void setCommand(int slot, MacroCommand partyOnMacro,  MacroCommand partyOffMacro) {
        /* 将“命令对象”（以其格式化后的超类Command来统一类型）
         * 安装到具体的“卡槽”slot上(分开槽与关槽)，
         * 这里将“针对超类接口”Command来编程，
         * 而不管具体命令对象是什么 */
        partyOnMacros[slot] = partyOnMacro;
        partyOffMacros[slot] = partyOffMacro;
    }

    public void onButtonWasPressed(int slot) {
        /* 调用“格式化后的动作”execute()
         * 就是调用“具体命令接收者的某个功能”,
         * 具体是什么功能，要看setCommand()方法
         * 送进来的是Command接口的哪一个具体的子类对象，
         * 以及其被格式化的命令是什么 */
        /* 针对“命令对象的接口”编程，
         * 只管执行格式化后的execute()方法就行，
         * 不管具体被格式化的是哪个具体命令，
         * 这是“命令模式”的精髓 */
        partyOnMacros[slot].execute();

        /* 每执行一次“动作按键”都被undoCommand记录，
         * 以便“撤销”操作 */
        undoMacro = partyOnMacros[slot];
    }

    public void offButtonWasPressed(int slot) {
        partyOffMacros[slot].execute();

        /* 每执行一次“动作按键”都被undoCommand记录，
         * undoCommand变量是“最后一个命令” */
        undoMacro = partyOffMacros[slot];
    }

    /* 增加一个“撤销”按键 */
    public void undoButtonWasPressed() {
        /* 因为“每一个命令都对应一个undo()”，故：
         * 按动撤销按键时，调用“最后一个命令 对应的undo()”命令，
         * 以实现“撤销最后一个命令” */
        undoMacro.undo();
    }

    public String toString() {
        StringBuffer stringBuff = new StringBuffer();
        stringBuff.append("\n------ Remote Control ------\n");
        for (int i = 0; i < partyOnMacros.length; i++) {
            stringBuff.append("[slot " + i + "] "
                    + partyOnMacros[i].getClass().getName()
                    + "   "
                    + partyOffMacros[i].getClass().getName()
                    + "\n"
            );
        }
        return stringBuff.toString();
    }
}
