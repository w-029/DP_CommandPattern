package Command;

/* 命令接口，是一个“将命令格式化”的工具
 * 所有的“命令对象”都继承这个这个超类，
 * 它们将通过继承超类来统一类型、封装不同的命令 */
public interface Command {
    /* 不同的命令接收者可能有不同的命令执行操作方法，
     * 但都会被封装为格式化的execute()方法 */
    public void execute();

    /* 每个“执行”命令都有自己对应的“撤销”命令 */
    public void undo();
}
