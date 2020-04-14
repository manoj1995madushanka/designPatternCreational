package prototype.deep;

import java.util.HashMap;
import java.util.Map;

public class Registry {
    private Map<String,Item> items = new HashMap<String, Item>();

    public Registry(){
        loadItems();
    }

    public Item createItem(String type){
        Item item =null;
        try{
            item = (Item)(items.get(type).clone());
        }catch(CloneNotSupportedException e){
            e.printStackTrace();
        }
        return item;
    }

    private void loadItems(){
        Movie movie = new Movie();
        movie.setTitle("basic movie");
        movie.setPrice(25.00);
        movie.setRuntime("2.5 hr");
        items.put("Movie",movie);

        Book book = new Book();
        book.setNumberOfPages(50);
        book.setPrice(2.50);
        book.setTitle("basic book");
        items.put("Book",book);
    }
}
