package CommandReciver;

/* 这是一个具体的“命令接收者”，
 * 其内的方法将是“真正被调用的方法”，
 * 但对它们的调用，都是通过“被格式化统一命令名称”进行 */
public class CeilingFan {
    public static final int HIGH = 3;
    public static final int MEDIUM = 2;
    public static final int LOW = 1;
    public static final int OFF = 0;
    String location;
    int speed;

    public CeilingFan(String location) {
        this.location = location;
        /* 初始状态 */
        speed = OFF;
    }

    /* 每一种“状态”都可达到一个“开”的效果 */
    public void high() {
        /* 记录状态 */
        speed = HIGH;
        /* 执行操作 */
        System.out.println(location + " CeilingFan is high");
    }

    /* 每一种“状态”都可达到一个“开”的效果 */
    public void medium() {
        /* 记录状态 */
        speed = MEDIUM;
        /* 执行操作 */
        System.out.println(location + " CeilingFan is medium");
    }

    /* 每一种“状态”都可达到一个“开”的效果 */
    public void low() {
        /* 记录状态 */
        speed = LOW;
        /* 执行操作 */
        System.out.println(location + " CeilingFan is low");
    }

    /* 既然一个“关”命令对应多档“开”命令
     *（这样不利于使用简单的undo()操作），
     * 那就将“关”于“开”都视为“平行的状态”，
     * 利用记录“前一个状态”来完成“撤销”的操作 */
    public void off() {
        /* OFF也视为一种状态 */
        speed = OFF;
        /* 执行操作 */
        System.out.println(location + " CeilingFan is off");
    }

    /* 获取当前速度 */
    public int getSpeed() {
        return speed;
    }
}
