package event;

/**
 * ClassName: CommonEvent
 * function:
 * Created by EDDY
 * CreateTime:2018/1/19
 */
public enum  CommonEvent {


    UPDATE_LIST (2);

    private int value ;

    CommonEvent(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
