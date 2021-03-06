import abstractFactory.creditCardSelector.CardType;
import abstractFactory.creditCardSelector.CreditCard;
import abstractFactory.creditCardSelector.CreditCardFactory;
import builder.Builder;
import builder.LunchOrder;
import factoryMethod.contactPage.Website;
import factoryMethod.contactPage.WebsiteFactory;
import factoryMethod.contactPage.WebsiteType;
import prototype.shallow.Record;
import prototype.deep.Movie;
import prototype.deep.Registry;
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

    private static void testDeepPrototype(){
        Registry registry = new Registry();
        Movie movie = (Movie) registry.createItem("Movie");
        movie.setTitle("deep Prototype");

        System.out.println(movie);
        System.out.println(movie.getRuntime());
        System.out.println(movie.getTitle());
        System.out.println(movie.getUrl());

        Movie anotherMovie = (Movie) registry.createItem("Movie");
        anotherMovie.setTitle("Gang of four");

        System.out.println(anotherMovie);
        System.out.println(anotherMovie.getRuntime());
        System.out.println(anotherMovie.getTitle());
        System.out.println(anotherMovie.getUrl());
    }

    private static void factoryMethodTest(){
        Website website = WebsiteFactory.getWebsite(WebsiteType.BLOG);
        System.out.println(website.getPages());
        website = WebsiteFactory.getWebsite(WebsiteType.SHOP);
        System.out.println(website.getPages());
    }

    private static void abstractFactoryTest(){
        CreditCardFactory abstractFactory = CreditCardFactory.getCreditCardFactory(775);
        CreditCard card = abstractFactory.getCreditCard(CardType.PLATINUM);
        System.out.println(card.getClass());
        abstractFactory = CreditCardFactory.getCreditCardFactory(600);
        CreditCard card2 = abstractFactory.getCreditCard(CardType.GOLD);
        System.out.println(card2.getClass());
    }

    public static void main (String[] args){
        Builder builder = new Builder();
        System.out.println(builder.stringBuilderTest());
        testShallowPrototype();
    }
}
