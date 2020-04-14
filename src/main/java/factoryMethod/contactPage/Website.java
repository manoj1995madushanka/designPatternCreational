package factoryMethod.contactPage;

import java.util.ArrayList;
import java.util.List;

public abstract class Website {
    protected List<Page> pages = new ArrayList<Page>();

    public List<Page> getPages(){
        return pages;
    }

    public Website(){
        this.createWebsite();
    }

    public abstract void createWebsite();
}
