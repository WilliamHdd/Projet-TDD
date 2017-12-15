import be.ecam.beerbar.BeerColor;
import be.ecam.beerbar.Bottle;
import be.ecam.beerbar.Brewery;
import be.ecam.beerbar.Stock;
import org.junit.Assert;
import org.junit.Test;

import java.util.AbstractMap;
import java.util.LinkedList;

public class MainTest {

    @Test
    public void shouldTest() {
        Assert.assertEquals("Hello", "Hello");
    }

    @Test
    public void addBottleTest() {
        Bottle bot = new Bottle("jupiler", 25, 4, BeerColor.BLONDE, Brewery.JUPILER);
        Assert.assertEquals(bot.getName(),"jupiler");
        Assert.assertEquals(bot.getVolume(),25);
        Assert.assertEquals(bot.getColor(),BeerColor.BLONDE);
    }

    @Test
    public void BeerColorTest() {
        String res = BeerColor.BLONDE.toString();
        Assert.assertEquals("Blonde", res);
    }

    @Test
    public void BreweryTest() {
        String res = Brewery.JUPILER.toString();
        Assert.assertEquals("Brasserie Jupiler", res);
    }

    @Test
    public void FindBeerByNameTest() {
        Stock s = new Stock();
        Bottle b = s.findBeerByName("Bokrijks");
        String res = b.toString();
        Assert.assertEquals("Bokrijks, 33cl, Rouge @ 7% d'alcool de Brasserie Alvinne", res);
    }

    @Test
    public void FindBeerByColorTest() {
        Stock s = new Stock();
        LinkedList<Bottle> b = s.findBeerByColor(BeerColor.ROUGE);
        int res = b.size();
        Assert.assertEquals(23, res);
    }

    @Test
    public void FindBeerByVolumeTest() {
        Stock s = new Stock();
        LinkedList<Bottle> b = s.findBeerByVolume(33);
        int res = b.size();
        Assert.assertEquals(105, res);
    }

    @Test
    public void EditBottleQuantityTest() {
        LinkedList<AbstractMap.SimpleEntry<Bottle,Integer>> beerList = new LinkedList();
        beerList.add(
                new AbstractMap.SimpleEntry (
                        new Bottle("test", 33, 7, BeerColor.BLONDE, Brewery.JUPILER), 1)
        );
        beerList.get(0).setValue(10);
        int res = beerList.get(0).getValue();
        Assert.assertEquals(10, res);
    }

}

