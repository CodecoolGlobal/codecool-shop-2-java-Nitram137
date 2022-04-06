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

ALTER TABLE ONLY public.products
    ADD CONSTRAINT fk_supplier_id FOREIGN KEY (supplier_id) REFERENCES public.suppliers(id),
    ADD CONSTRAINT fk_category_id FOREIGN KEY (category_id) REFERENCES public.categories(id);
