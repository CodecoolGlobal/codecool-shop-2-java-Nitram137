DROP TABLE IF EXISTS public.products;
DROP TABLE IF EXISTS public.suppliers;
DROP TABLE IF EXISTS public.categories;
DROP TABLE IF EXISTS public.bundles;

CREATE TABLE public.products (
    id serial NOT NULL PRIMARY KEY,
    name text NOT NULL,
    default_price decimal(5,3),
    currency_string text NOT NULL,
    description text,
    supplier_id integer NOT NULL,
    category_id integer NOT NULL
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

ALTER TABLE ONLY public.products
    ADD CONSTRAINT fk_supplier_id FOREIGN KEY (supplier_id) REFERENCES public.suppliers(id),
    ADD CONSTRAINT fk_category_id FOREIGN KEY (category_id) REFERENCES public.categories(id);

ALTER TABLE ONLY public.products_bundles
    ADD CONSTRAINT fk_bundle_id FOREIGN KEY (bundle_id) REFERENCES public.bundles(id),
    ADD CONSTRAINT fk_product_id FOREIGN KEY (product_id) REFERENCES public.products(id);
