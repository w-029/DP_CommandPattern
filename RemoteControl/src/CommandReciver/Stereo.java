package CommandReciver;

/* 这里有三种播放对象，
 * 每一种的立体声响的打开都需要一串动作，
 * 操作起来及其不便，
 * 尤其是：无法与其他设备的开关统一起来，
 * 所以“命令模式”显得尤为重要 */
public class Stereo {

    public void on() {
        System.out.println("Stereo is On");
    }

    public void off() {
        System.out.println("Stereo is Off");
    }

    public void setCd() {
        System.out.println("CD is Set");
    }

    public void setDvd() {
        System.out.println("Dvd is Set");
    }

    public void setRadio() {
        System.out.println("Radio is Set");
    }

    public void setVolume() {
        System.out.println("Volume is Set");
    }

}
