package com.codecool.shop.config;

import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.SupplierDao;
import com.codecool.shop.dao.implementation.ProductCategoryDaoMem;
import com.codecool.shop.dao.implementation.ProductDaoMem;
import com.codecool.shop.dao.implementation.SupplierDaoMem;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.Supplier;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.math.BigDecimal;

@WebListener
public class Initializer implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ProductDao productDataStore = ProductDaoMem.getInstance();
        ProductCategoryDao productCategoryDataStore = ProductCategoryDaoMem.getInstance();
        SupplierDao supplierDataStore = SupplierDaoMem.getInstance();

        //setting up a new supplier
        Supplier lowie = new Supplier("LoW Interactive Entertainment", "We don't actually know what we supposed to do.");
        supplierDataStore.add(lowie);
        Supplier coolSticks = new Supplier("CoolSticks Co.", "World's #1 supplier of sticks.");
        supplierDataStore.add(coolSticks);
        Supplier funnyHats = new Supplier("Funny Hat Store", "Hats in all shapes and sizes.");
        supplierDataStore.add(funnyHats);
        Supplier epicRides = new Supplier("Epic Rides Inc.", "In occasions when you gotta go fast, boi!");
        supplierDataStore.add(epicRides);
        Supplier titleTech = new Supplier("Title Tech Corps.", "Supplying titles with cutting-edge technology.");
        supplierDataStore.add(titleTech);
        Supplier buffBros = new Supplier("Buff Bros.", "You need buff, you get buff!");
        supplierDataStore.add(buffBros);
        Supplier ammuNation = new Supplier("Ammu-Nation", "Protecting your rights!");
        supplierDataStore.add(ammuNation);
        Supplier hacksmith = new Supplier("Hacksmith Industries", "They actually made a lightsaber IRL!");
        supplierDataStore.add(hacksmith);
        Supplier pandora = new Supplier("Pandora", "That's the jewellery store.");
        supplierDataStore.add(pandora);
        Supplier ea = new Supplier("Electronic Arts", "Your money and your life!");
        supplierDataStore.add(ea);

        //setting up a new product category
        ProductCategory games = new ProductCategory("Games", "Software", "The main feature of our web shop.");
        productCategoryDataStore.add(games);
        ProductCategory items = new ProductCategory("Items", "In-game", "All the equippable in-game stuff.");
        productCategoryDataStore.add(items);
        ProductCategory mounts = new ProductCategory("Mounts", "In-game", "The best steads money can buy.");
        productCategoryDataStore.add(mounts);
        ProductCategory titles = new ProductCategory("Titles", "In-game", "Show your superiority by attaching one of these neat titles to your name.");
        productCategoryDataStore.add(titles);
        ProductCategory buffs = new ProductCategory("Buffs", "In-game", "Why waste your time getting gud, when you can just buy a buff instead?");
        productCategoryDataStore.add(buffs);

        //setting up products and printing it
        productDataStore.add(new Product("League of Warcrimes", new BigDecimal("0.999"), "BTC", "Our greatly anticipated hit title. In development since times unknown. Releasing in a similar timeframe.", games, lowie));
        productDataStore.add(new Product("League of Warcrimes: Elder Ringing", new BigDecimal("0.333"), "BTC", "The first DLC that will come out eventually", games, lowie));
        productDataStore.add(new Product("League of Warcrimes: Ending Strike Tales", new BigDecimal("0.666"), "BTC", "Our final masterpiece! It probably won't release in your lifetime though. If it releases at all before the end of the world.", games, lowie));
        productDataStore.add(new Product("Cool Stick That I Found", new BigDecimal("0.001"), "BTC", "Found this cool stick as a 23 year old.", items, coolSticks));
        productDataStore.add(new Product("Elden Ring", new BigDecimal("0.5"), "BTC", "Foul tarnished, in search of the Elden Ring. Emboldened by the flame of ambition. Someone must extinguish thy flame. - Margit the Fell", items, pandora));
        productDataStore.add(new Product("EA Controller", new BigDecimal("0.009"), "BTC", "With this you will be able to buy microtransactions in-game... when the game eventually comes out.", items, ea));
        productDataStore.add(new Product("Lightsaber", new BigDecimal("0.066"), "BTC", "The force be with you.", items, hacksmith));
        productDataStore.add(new Product("M4A4 Dragon King", new BigDecimal("0.046"), "BTC", "A weapon worthy of the Monkey King himself.", items, ammuNation));





    }
}
