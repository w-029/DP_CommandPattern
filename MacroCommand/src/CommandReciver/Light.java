package CommandReciver;

/* 这是一个具体的“命令接收者”，
 * 其内的方法将是“真正被调用的方法”，
 * 但对它们的调用，都是通过“被格式化统一命令名称”进行 */
public class Light {

    public void on() {
        System.out.println("Light is On");
    }

    /* “开”于“关”互为逆操作，
     * 这种一对一的简单的关系最好事先undo()操作 */
    public void off() {
        System.out.println("Light is Off");
    }

}
