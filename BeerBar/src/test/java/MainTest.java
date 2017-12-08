import be.ecam.beerbar.BeerColor;
import be.ecam.beerbar.Bottle;
import be.ecam.beerbar.Brewery;
import org.junit.Assert;
import org.junit.Test;

public class MainTest {

    @Test
    public void shouldTest() {
        Assert.assertEquals("Hello", "Hello");
    }

    public void addBottleTest() {
        Bottle bot = new Bottle("jupiler", 25, 4, BeerColor.BLONDE, Brewery.JUPILER);
        Assert.assertEquals(bot.getName(),"jupiler");
        Assert.assertEquals(bot.getVolume(),25);
        Assert.assertEquals(bot.getColor(),BeerColor.BLONDE);
    }

    public void saikou() {
        Assert.assertEquals("SaikouIsStupid", "SaikouIsStupidd");

    }

}

