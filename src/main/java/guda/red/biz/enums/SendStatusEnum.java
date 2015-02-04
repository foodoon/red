package guda.red.biz.enums;

/**
 * Created by foodoon on 2015/2/4.
 */
public enum SendStatusEnum {

    INIT("初始化",0),
    SUCCESS("发送成功",1),
    FAIL("发送失败",2),
    ;

    private int value;
    private String name;
    private SendStatusEnum(String name,int val){
        this.name = name;
        this.value = val;
    }
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static String getNameByValue(int val){
        SendStatusEnum[] values = SendStatusEnum.values();
        for(SendStatusEnum e:values){
            if(e.getValue() == val){
                return e.getName();
            }
        }
        return null;
    }

}
