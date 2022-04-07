package com.codecool.shop.config;

import com.codecool.shop.controller.CartController;
import com.codecool.shop.controller.ProductAPIController;
import com.codecool.shop.controller.ProductController;
import com.codecool.shop.dao.BundleDao;
import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.SupplierDao;
import com.codecool.shop.dao.db_implementation.ShopDatabaseManager;
import com.codecool.shop.dao.implementation.BundleDaoMem;
import com.codecool.shop.dao.implementation.ProductCategoryDaoMem;
import com.codecool.shop.dao.implementation.ProductDaoMem;
import com.codecool.shop.dao.implementation.SupplierDaoMem;
import com.codecool.shop.model.Bundle;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.Supplier;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Objects;

@WebListener
public class Initializer implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        ShopDatabaseManager dbManager = ShopDatabaseManager.getInstance();
        ProductDao productDataStore = null;
        ProductCategoryDao productCategoryDataStore = null;
        SupplierDao supplierDataStore = null;
        BundleDao bundleDataStore = null;

        try {
            dbManager.setup();
        } catch (SQLException | IOException ex) {
            System.out.println("Cannot connect to database.");
        }

        var daoProperty = dbManager.getProperties().getProperty("dao");

        if(Objects.equals(daoProperty, "memory")) {
            productDataStore = ProductDaoMem.getInstance();
            productCategoryDataStore = ProductCategoryDaoMem.getInstance();
            supplierDataStore = SupplierDaoMem.getInstance();
            bundleDataStore = BundleDaoMem.getInstance();

            //setting up a new supplier
            Supplier lowie = new Supplier("LoW Interactive Entertainment");
            supplierDataStore.add(lowie);
            Supplier coolSticks = new Supplier("CoolSticks Co.");
            supplierDataStore.add(coolSticks);
            Supplier funnyHats = new Supplier("Funny Hat Store");
            supplierDataStore.add(funnyHats);
            Supplier epicRides = new Supplier("Epic Rides Inc.");
            supplierDataStore.add(epicRides);
            Supplier titleTech = new Supplier("Title Tech Corps.");
            supplierDataStore.add(titleTech);
            Supplier buffBros = new Supplier("Buff Bros.");
            supplierDataStore.add(buffBros);
            Supplier ammuNation = new Supplier("Ammu-Nation");
            supplierDataStore.add(ammuNation);
            Supplier hacksmith = new Supplier("Hacksmith Industries");
            supplierDataStore.add(hacksmith);
            Supplier pandora = new Supplier("Pandora");
            supplierDataStore.add(pandora);
            Supplier ea = new Supplier("Electronic Arts");
            supplierDataStore.add(ea);

            //setting up a new product category
            ProductCategory games = new ProductCategory("Games", "Software");
            productCategoryDataStore.add(games);
            ProductCategory items = new ProductCategory("Items", "In-game");
            productCategoryDataStore.add(items);
            ProductCategory mounts = new ProductCategory("Mounts", "In-game");
            productCategoryDataStore.add(mounts);
            ProductCategory titles = new ProductCategory("Titles", "In-game");
            productCategoryDataStore.add(titles);
            ProductCategory buffs = new ProductCategory("Buffs", "In-game");
            productCategoryDataStore.add(buffs);

            //setting up products and printing it
            productDataStore.add(new Product("League of Warcrimes", new BigDecimal("0.999"), "BTC", "Our greatly anticipated hit title. In development since times ancient. Releasing in a day that is may yet to come.", games, lowie));
            productDataStore.add(new Product("League of Warcrimes: Elder Ringing", new BigDecimal("0.333"), "BTC", "The first DLC that will come out eventually. Picture a bunch of old people ringing a bell. That's a good game design.", games, lowie));
            productDataStore.add(new Product("League of Warcrimes: Ending Strike Tales", new BigDecimal("0.666"), "BTC", "Our final masterpiece! It probably won't release in our lifetime though. If it releases at all before the end of the world.", games, lowie));

            productDataStore.add(new Product("Cool Stick That I Found", new BigDecimal("0.001"), "BTC", "Found this cool stick, don't know what to do with it, guess I'll sell it here.", items, coolSticks));
            productDataStore.add(new Product("Elden Ring", new BigDecimal("0.5"), "BTC", "Foul tarnished, in search of the Elden Ring. Emboldened by the flame of ambition. Someone must extinguish thy flame. - Margit the Fell", items, pandora));
            productDataStore.add(new Product("EA Controller", new BigDecimal("0.009"), "BTC", "Buy this to buy microtransactions in-game... when the game eventually comes out.", items, ea));
            productDataStore.add(new Product("Lightsaber", new BigDecimal("0.066"), "BTC", "The force be with you.", items, hacksmith));
            productDataStore.add(new Product("M4A4 Dragon King", new BigDecimal("0.046"), "BTC", "A weapon worthy of the Monkey King himself.", items, ammuNation));
            productDataStore.add(new Product("Wooden Sword", new BigDecimal("0.002"), "BTC", "Every war criminal has to start somewhere.", items, coolSticks));
            productDataStore.add(new Product("Fedora", new BigDecimal("0.042"), "BTC", "For all you nice guys and discord mods out there.", items, funnyHats));
            productDataStore.add(new Product("Sombrero", new BigDecimal("0.023"), "BTC", "Fashionable moustache not included.", items, funnyHats));
            productDataStore.add(new Product("Bald Cap", new BigDecimal("0.01"), "BTC", "100% guarantee to stop hair loss permanently!", items, funnyHats));
            productDataStore.add(new Product("Thunderfury, Blessed Blade of the Windseeker", new BigDecimal("0.142"), "BTC", "Ragnaros the Firelord, and his lieutenants Garr and Baron Geddon, defeated Thunderaan, Prince of Air, after the First Age of Creation, during the Elemental Sundering. Ragnaros was unable to fully consume Thunderaan’s essence, so he forced what little remained into a talisman of elemental binding and shattered it. He gave the two halves to his lieutenants. Ages passed, and somehow the talisman halves found their way into the hands of Highlord Demitrian, a follower of Thunderaan. He recombined the talisman but was unable to release his master. Instead, he did the best he could: He crafted a blade to serve as a vessel for his master's essence.", items, hacksmith));

            productDataStore.add(new Product("2001 Honda Civic", new BigDecimal("0.201"), "BTC", "Vehicular manslaughter is a capital offense.", mounts, epicRides));
            productDataStore.add(new Product("Bimbus 2002", new BigDecimal("0.105"), "BTC", "Ordinary broom, you can pretend to be able to fly with it.", mounts, coolSticks));
            productDataStore.add(new Product("Rotációs Kapa", new BigDecimal("0.295"), "BTC", "Woe to all those wretched souls that gets caught in the ruthless blades of this beast.", mounts, epicRides));
            productDataStore.add(new Product("Rivendare's Deathcharger", new BigDecimal("0.405"), "BTC", "That damned horse doesn't want to drop for me in Stratholme.", mounts, epicRides));
            productDataStore.add(new Product("Jukker", new BigDecimal("0.264"), "BTC", "Hope in kid, there's no time to explain.", mounts, epicRides));
            productDataStore.add(new Product("Flying Traffic Rug", new BigDecimal("0.311"), "BTC", "The streets that raised us, raise us.", mounts, epicRides));

            productDataStore.add(new Product("I am rich!", new BigDecimal("1"), "BTC", "No better way to express your wealth, than paying thousands of dollars for this stupid title.", titles, titleTech));
            productDataStore.add(new Product("Slayer of Enemies", new BigDecimal("0.1"), "BTC", "Every video game title ever.", titles, titleTech));
            productDataStore.add(new Product("The Beta Tester", new BigDecimal("0.25"), "BTC", "Show that you were there before the beginning.", titles, titleTech));
            productDataStore.add(new Product("Buyer of False Goods", new BigDecimal("0.01"), "BTC", "This one already knows.", titles, titleTech));
            productDataStore.add(new Product("Proud Warlord", new BigDecimal("0.21"), "BTC", "It feels good to be bad and you're tired of pretending it doesn't.", titles, titleTech));

            productDataStore.add(new Product("Infinite Well-being", new BigDecimal("0.8"), "BTC", "You will feel content with yourself and the world around you.", buffs, buffBros));
            productDataStore.add(new Product("Ketamine addiction", new BigDecimal("0.4"), "BTC", "Makes you feel good, but Allah won't be satisfied with you.", buffs, buffBros));
            productDataStore.add(new Product("Neck beard", new BigDecimal("0.420"), "BTC", "You will suddenly feel the urge to become a moderator on discord, also makes you irresistible to women.", buffs, buffBros));
            productDataStore.add(new Product("Elongated Musk", new BigDecimal("0.12"), "BTC", "Makes your musk elongated. Just don't start sending Teslas to space.", buffs, buffBros));
            productDataStore.add(new Product("Maidenlessness", new BigDecimal("0.22"), "BTC", "Oh, yes... Tarnished are we? Come to the Lands between for the Elden Ring, hmm? Of course you have. No shame in it. Unfortunately for you, however, you are maidenless.", buffs, buffBros));
            productDataStore.add(new Product("Tourette-syndrome", new BigDecimal("0.050"), "BTC", "Makes you privileged to swear all you want.", buffs, buffBros));

            //setting up new bundles
            Bundle yoda = new Bundle("Master Yoda Kit", "Everything you need to become a true jedi.", productDataStore.getAll().get(6), productDataStore.getAll().get(13), productDataStore.getAll().get(25));
            bundleDataStore.add(yoda);
            Bundle discordMod = new Bundle("Discord Moderator Set", "This combo makes you irresistible to any human being.", productDataStore.getAll().get(9), productDataStore.getAll().get(26));
            bundleDataStore.add(discordMod);
            Bundle tarnished = new Bundle("Tarnished Package", "Straight from the Lands Beyond.", productDataStore.getAll().get(4), productDataStore.getAll().get(28));
            bundleDataStore.add(tarnished);

        } else if(Objects.equals(daoProperty, "jdbc")) {
            productDataStore = dbManager.getProductDao();
            productCategoryDataStore = dbManager.getCategoryDao();
            supplierDataStore = dbManager.getSupplierDao();
            bundleDataStore = dbManager.getBundleDao();
        }

        ServletContext context = sce.getServletContext();
        context.addServlet("Product", new ProductController(productDataStore, productCategoryDataStore, bundleDataStore, supplierDataStore)).addMapping("/");
        context.addServlet("CartController", new CartController(productDataStore, bundleDataStore)).addMapping("/api/cart");
        context.addServlet("ProductAPI", new ProductAPIController(productDataStore)).addMapping("/api/product");
    }
}
