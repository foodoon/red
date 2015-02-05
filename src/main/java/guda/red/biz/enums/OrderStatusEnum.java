package guda.red.biz.enums;

/**
 * Created by foodoon on 2015/2/5.
 */
public enum OrderStatusEnum {

    INIT("待付款",0),
    SUCCESS("付款成功",1),
    FAIL("付款失败",2),
    ;

    private int value;
    private String name;
    private OrderStatusEnum(String name, int val){
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
        OrderStatusEnum[] values = OrderStatusEnum.values();
        for(OrderStatusEnum e:values){
            if(e.getValue() == val){
                return e.getName();
            }
        }
        return null;
    }
}
