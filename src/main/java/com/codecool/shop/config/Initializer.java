package com.codecool.shop.config;

import com.codecool.shop.dao.BundleDao;
import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.SupplierDao;
import com.codecool.shop.dao.implementation.BundleDaoMem;
import com.codecool.shop.dao.implementation.ProductCategoryDaoMem;
import com.codecool.shop.dao.implementation.ProductDaoMem;
import com.codecool.shop.dao.implementation.SupplierDaoMem;
import com.codecool.shop.model.Bundle;
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
        BundleDao bundleDataStore = BundleDaoMem.getInstance();

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
        productDataStore.add(new Product("League of Warcrimes: Elder Ringing", new BigDecimal("0.333"), "BTC", "The first DLC that will come out eventually. Picture a bunch of old people ringing a bell. That's a good game design.", games, lowie));
        productDataStore.add(new Product("League of Warcrimes: Ending Strike Tales", new BigDecimal("0.666"), "BTC", "Our final masterpiece! It probably won't release in your lifetime though. If it releases at all before the end of the world.", games, lowie));

        productDataStore.add(new Product("Cool Stick That I Found", new BigDecimal("0.001"), "BTC", "Found this cool stick as a 23 year old.", items, coolSticks));
        productDataStore.add(new Product("Elden Ring", new BigDecimal("0.5"), "BTC", "Foul tarnished, in search of the Elden Ring. Emboldened by the flame of ambition. Someone must extinguish thy flame. - Margit the Fell", items, pandora));
        productDataStore.add(new Product("EA Controller", new BigDecimal("0.009"), "BTC", "With this you will be able to buy microtransactions in-game... when the game eventually comes out.", items, ea));
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
        productDataStore.add(new Product("Maidenlessness", new BigDecimal("0.22"), "BTC", "Make of thyselves that which ye desire. Be it a Lord. Be it a God. But should ye fail to become aught at all, ye will be forsaken. Amounting only to sacrifices.", buffs, buffBros));
        productDataStore.add(new Product("Tourette-syndrome", new BigDecimal("0.050"), "BTC", "Makes you privileged to swear all you want.", buffs, buffBros));

        //setting up new bundles
        Bundle yoda = new Bundle("Master Yoda Kit", "Everything you need to become a true jedi.", productDataStore.getAll().get(6), productDataStore.getAll().get(13), productDataStore.getAll().get(25));
        bundleDataStore.add(yoda);
        Bundle discordMod = new Bundle("Discord Moderator Set", "Makes you irresistible to any human being.", productDataStore.getAll().get(9), productDataStore.getAll().get(26));
        bundleDataStore.add(discordMod);
        Bundle tarnished = new Bundle("Tarnished Package", "Straight from the Lands Beyond.", productDataStore.getAll().get(4), productDataStore.getAll().get(28));
        bundleDataStore.add(tarnished);
    }
}
