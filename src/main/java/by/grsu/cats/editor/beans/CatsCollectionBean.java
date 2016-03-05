package by.grsu.cats.editor.beans;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by vviital on 5.3.16.
 */
public class CatsCollectionBean {

    private Map<Long, CatBean> catBeanMap = new HashMap<Long, CatBean>();

    public CatsCollectionBean() {

    }

    public Map<Long, CatBean> getCatBeanMap() {
        return this.catBeanMap;
    }

    public void addCat(CatBean cat) {
        this.catBeanMap.put(cat.getHash(), cat);
    }

    public boolean tryRemove(long hash) {
        boolean ok = true;
        if (find(hash)) {
            this.catBeanMap.remove(hash);
        } else {
            ok = false;
        }
        return ok;
    }

    public CatBean getCat(long hash) {
        if (find(hash)) return this.catBeanMap.get(hash);
        return new CatBean();
    }

    public boolean find(long hash) {
        return this.catBeanMap.containsKey(hash);
    }
}
