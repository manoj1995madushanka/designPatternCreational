import builder.Builder;
import builder.LunchOrder;

public class Main {

    private void testBuilder()
    {
        LunchOrder.Builder builder = new LunchOrder.Builder();
        builder.bread("bread").condiments("condiments").dressing("dressing").meat("meat");
        // LunchOrder lunchOrder = new LunchOrder();
        LunchOrder lunchOrder = builder.build();

        System.out.println(lunchOrder.getBread());
        System.out.println(lunchOrder.getCondiments());
        System.out.println(lunchOrder.getDressing());
        System.out.println(lunchOrder.getMeat());
    }

    public static void main (String[] args){
        Builder builder = new Builder();
        System.out.println(builder.stringBuilderTest());
    }
}
