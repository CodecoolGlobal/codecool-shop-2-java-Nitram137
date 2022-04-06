DROP TABLE IF EXISTS public.products CASCADE;
DROP TABLE IF EXISTS public.suppliers;
DROP TABLE IF EXISTS public.categories;
DROP TABLE IF EXISTS public.bundles CASCADE;
DROP TABLE IF EXISTS public.products_bundles CASCADE;

CREATE TABLE public.products (
    id serial NOT NULL PRIMARY KEY,
    name text NOT NULL,
    default_price decimal(5,3),
    currency_string text NOT NULL,
    description text,
    category_id integer NOT NULL,
    supplier_id integer NOT NULL
);

CREATE TABLE public.suppliers (
    id serial NOT NULL PRIMARY KEY,
    name text NOT NULL
);

CREATE TABLE public.categories (
    id serial NOT NULL PRIMARY KEY,
    name text NOT NULL,
    department text NOT NULL
);

CREATE TABLE public.bundles (
    id serial NOT NULL PRIMARY KEY,
    name text NOT NULL,
    description text NOT NULL
);

CREATE TABLE public.products_bundles (
    id serial NOT NULL PRIMARY KEY,
    bundle_id integer NOT NULL,
    product_id integer NOT NULL
);


INSERT INTO public.products (name, default_price, currency_string, description, category_id, supplier_id) VALUES
    ('League of Warcrimes', 0.999, 'BTC', 'Our greatly anticipated hit title. In development since times ancient. Releasing in a day that is may yet to come.', 1, 1),
    ('League of Warcrimes: Elder Ringing', 0.333, 'BTC', 'The first DLC that will come out eventually. Picture a bunch of old people ringing a bell. That''s a good game design.', 1, 1),
    ('League of Warcrimes: Ending Strike Tales', 0.666, 'BTC', 'Our final masterpiece! It probably won''t release in our lifetime though. If it releases at all before the end of the world.', 1, 1),
    ('Cool Stick That I Found', 0.001, 'BTC', 'Found this cool stick, don''t know what to do with it, guess I''ll sell it here.', 2, 2),
    ('Elden Ring', 0.5, 'BTC', 'Foul tarnished, in search of the Elden Ring. Emboldened by the flame of ambition. Someone must extinguish thy flame. - Margit the Fell', 2, 9),
    ('EA Controller', 0.009, 'BTC', 'Buy this to buy microtransactions in-game... when the game eventually comes out.', 2, 9),
    ('Lightsaber', 0.066, 'BTC', 'The force be with you.', 2, 8),
    ('M4A4 Dragon King', 0.046, 'BTC', 'A weapon worthy of the Monkey King himself.', 2, 6),
    ('Wooden Sword', 0.002, 'BTC', 'Every war criminal has to start somewhere.', 2, 2),
    ('Fedora', 0.042, 'BTC', 'For all you nice guys and discord mods out there.', 2, 3),
    ('Sombrero', 0.023, 'BTC', 'Fashionable moustache not included.', 2, 3),
    ('Bald Cap', 0.01, 'BTC', '100% guarantee to stop hair loss permanently!', 2, 3),
    ('Thunderfury, Blessed Blade of the Windseeker', 0.142, 'BTC', 'Ragnaros the Firelord, and his lieutenants Garr and Baron Geddon, defeated Thunderaan, Prince of Air, after the First Age of Creation, during the Elemental Sundering. Ragnaros was unable to fully consume Thunderaan’s essence, so he forced what little remained into a talisman of elemental binding and shattered it. He gave the two halves to his lieutenants. Ages passed, and somehow the talisman halves found their way into the hands of Highlord Demitrian, a follower of Thunderaan. He recombined the talisman but was unable to release his master. Instead, he did the best he could: He crafted a blade to serve as a vessel for his master''s essence.', 2, 8),
    ('2001 Honda Civic', 0.201, 'BTC', 'Vehicular manslaughter is a capital offense.', 3, 4),
    ('Bimbus 2002', 0.105, 'BTC', 'Ordinary broom, you can pretend to be able to fly with it.', 3, 2),
    ('Rotációs Kapa', 0.295, 'BTC', 'Woe to all those wretched souls that gets caught in the ruthless blades of this beast.', 3, 4),
    ('Rivendare''s Deathcharger', 0.405, 'BTC', 'That damned horse doesn''t want to drop for me in Stratholme.', 3, 4),
    ('Jukker', 0.264, 'BTC', 'Hope in kid, there''s no time to explain.', 3, 4),
    ('Flying Traffic Rug', 0.311, 'BTC', 'The streets that raised us, raise us.', 3, 4),
    ('I am rich!', 1, 'BTC', 'No better way to express your wealth, than paying thousands of dollars for this stupid title.', 4, 5),
    ('Slayer of Enemies', 0.1, 'BTC', 'Every video game title ever.', 4, 5),
    ('The Beta Tester', 0.25, 'BTC', 'Show that you were there before the beginning.', 4, 5),
    ('Buyer of False Goods', 0.01, 'BTC', 'This one already knows.', 4, 5),
    ('Proud Warlord', 0.21, 'BTC', 'It feels good to be bad and you''re tired of pretending it doesn''t.', 4, 5),
    ('Infinite Well-being', 0.8, 'BTC', 'You will feel content with yourself and the world around you.', 5, 6),
    ('Ketamine addiction', 0.4, 'BTC', 'Makes you feel good, but Allah won''t be satisfied with you.', 5, 6),
    ('Neck beard', 0.420, 'BTC', 'You will suddenly feel the urge to become a moderator on discord, also makes you irresistible to women.', 5, 6),
    ('Elongated Musk', 0.12, 'BTC', 'Makes your musk elongated. Just don''t start sending Teslas to space.', 5, 6),
    ('Maidenlessness', 0.22, 'BTC', 'Oh, yes... Tarnished are we? Come to the Lands between for the Elden Ring, hmm? Of course you have. No shame in it. Unfortunately for you, however, you are maidenless.', 5, 6),
    ('Tourette-syndrome', 0.050, 'BTC', 'Makes you privileged to swear all you want.', 5, 6);

INSERT INTO public.suppliers (name) VALUES
    ('LoW Interactive Entertainment'),
    ('CoolSticks Co.'),
    ('Funny Hat Store'),
    ('Epic Rides Inc.'),
    ('Title Tech Corps.'),
    ('Buff Bros.'),
    ('Ammu-Nation'),
    ('Hacksmith Industries'),
    ('Pandora'),
    ('Electronic Arts');

INSERT INTO public.categories (name, department) VALUES
    ('Games', 'Software'),
    ('Items', 'In-game'),
    ('Mounts', 'In-game'),
    ('Titles', 'In-game'),
    ('Buffs', 'In-game');

INSERT INTO public.bundles (name, description) VALUES
    ('Master Yoda Kit', 'Everything you need to become a true jedi.'),
    ('Discord Moderator Set', 'This combo makes you irresistible to any human being.'),
    ('Tarnished Package', 'Straight from the Lands Beyond.');

INSERT INTO public.products_bundles (bundle_id, product_id) VALUES
    (1, 7),
    (1, 14),
    (1, 26),
    (2, 10),
    (2, 27),
    (3, 5),
    (3, 29);

ALTER TABLE ONLY public.products
    ADD CONSTRAINT fk_supplier_id FOREIGN KEY (supplier_id) REFERENCES public.suppliers(id),
    ADD CONSTRAINT fk_category_id FOREIGN KEY (category_id) REFERENCES public.categories(id);

ALTER TABLE ONLY public.products_bundles
    ADD CONSTRAINT fk_bundle_id FOREIGN KEY (bundle_id) REFERENCES public.bundles(id),
    ADD CONSTRAINT fk_product_id FOREIGN KEY (product_id) REFERENCES public.products(id);