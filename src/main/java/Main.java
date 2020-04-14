import builder.Builder;
import builder.LunchOrder;
import prototype.Record;
import prototype.shallow.Statement;

import java.util.ArrayList;
import java.util.List;

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

    private static void testShallowPrototype(){
        // this is shallow prototype because I clone object that will duplicate same object
        String sql ="select * rom movies where title = ?";
        List<String> parameters = new ArrayList<String>();
        parameters.add("star wars");
        Record record = new Record();
        Statement statement = new Statement(sql,parameters,record);
        Statement anotherStatement = statement.clone();
        System.out.println(statement.getSql());
        System.out.println(statement.getParameters());
        System.out.println(statement.getRecord());
        System.out.println(anotherStatement.getSql());
        System.out.println(anotherStatement.getParameters());
        System.out.println(anotherStatement.getRecord());
    }

    public static void main (String[] args){
        Builder builder = new Builder();
        System.out.println(builder.stringBuilderTest());
        testShallowPrototype();
    }
}
