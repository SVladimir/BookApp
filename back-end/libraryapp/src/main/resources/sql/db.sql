PGDMP     ;                    y            booksdb    12.5    12.5     2           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            3           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            4           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            5           1262    25646    booksdb    DATABASE     ?   CREATE DATABASE booksdb WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Macedonian_North Macedonia.1251' LC_CTYPE = 'Macedonian_North Macedonia.1251';
    DROP DATABASE booksdb;
                postgres    false            ?            1259    33840    author    TABLE     ?   CREATE TABLE public.author (
    ssn character varying(13) NOT NULL,
    birth_date timestamp without time zone,
    last_name character varying(255),
    name character varying(255)
);
    DROP TABLE public.author;
       public         heap    postgres    false            ?            1259    33848    book    TABLE     ?   CREATE TABLE public.book (
    book_id bigint NOT NULL,
    description character varying(255),
    edition bigint,
    name character varying(200),
    publisher_publisher_id bigint
);
    DROP TABLE public.book;
       public         heap    postgres    false            ?            1259    33853    book_category    TABLE     d   CREATE TABLE public.book_category (
    book_id bigint NOT NULL,
    category_id bigint NOT NULL
);
 !   DROP TABLE public.book_category;
       public         heap    postgres    false            ?            1259    33856    book_from_authors    TABLE     o   CREATE TABLE public.book_from_authors (
    book_id bigint NOT NULL,
    ssn character varying(13) NOT NULL
);
 %   DROP TABLE public.book_from_authors;
       public         heap    postgres    false            ?            1259    33859    category    TABLE     c   CREATE TABLE public.category (
    category_id bigint NOT NULL,
    name character varying(255)
);
    DROP TABLE public.category;
       public         heap    postgres    false            ?            1259    33838    hibernate_sequence    SEQUENCE     {   CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.hibernate_sequence;
       public          postgres    false            ?            1259    33864 	   publisher    TABLE     ?   CREATE TABLE public.publisher (
    publisher_id bigint NOT NULL,
    address character varying(255),
    name character varying(255)
);
    DROP TABLE public.publisher;
       public         heap    postgres    false            ?            1259    33872    source    TABLE     ?   CREATE TABLE public.source (
    source_id bigint NOT NULL,
    format character varying(255),
    url character varying(255),
    sources_book_id bigint,
    img_src character varying(255)
);
    DROP TABLE public.source;
       public         heap    postgres    false            )          0    33840    author 
   TABLE DATA                 public          postgres    false    203   !       *          0    33848    book 
   TABLE DATA                 public          postgres    false    204   h"       +          0    33853    book_category 
   TABLE DATA                 public          postgres    false    205   ?$       ,          0    33856    book_from_authors 
   TABLE DATA                 public          postgres    false    206   %       -          0    33859    category 
   TABLE DATA                 public          postgres    false    207   ?%       .          0    33864 	   publisher 
   TABLE DATA                 public          postgres    false    208   -&       /          0    33872    source 
   TABLE DATA                 public          postgres    false    209   ?&       6           0    0    hibernate_sequence    SEQUENCE SET     B   SELECT pg_catalog.setval('public.hibernate_sequence', 367, true);
          public          postgres    false    202            ?
           2606    33847    author author_pkey 
   CONSTRAINT     Q   ALTER TABLE ONLY public.author
    ADD CONSTRAINT author_pkey PRIMARY KEY (ssn);
 <   ALTER TABLE ONLY public.author DROP CONSTRAINT author_pkey;
       public            postgres    false    203            ?
           2606    33852    book book_pkey 
   CONSTRAINT     Q   ALTER TABLE ONLY public.book
    ADD CONSTRAINT book_pkey PRIMARY KEY (book_id);
 8   ALTER TABLE ONLY public.book DROP CONSTRAINT book_pkey;
       public            postgres    false    204            ?
           2606    33863    category category_pkey 
   CONSTRAINT     ]   ALTER TABLE ONLY public.category
    ADD CONSTRAINT category_pkey PRIMARY KEY (category_id);
 @   ALTER TABLE ONLY public.category DROP CONSTRAINT category_pkey;
       public            postgres    false    207            ?
           2606    33871    publisher publisher_pkey 
   CONSTRAINT     `   ALTER TABLE ONLY public.publisher
    ADD CONSTRAINT publisher_pkey PRIMARY KEY (publisher_id);
 B   ALTER TABLE ONLY public.publisher DROP CONSTRAINT publisher_pkey;
       public            postgres    false    208            ?
           2606    33879    source source_pkey 
   CONSTRAINT     W   ALTER TABLE ONLY public.source
    ADD CONSTRAINT source_pkey PRIMARY KEY (source_id);
 <   ALTER TABLE ONLY public.source DROP CONSTRAINT source_pkey;
       public            postgres    false    209            ?
           2606    33895 -   book_from_authors fk330mv2v751ogeiin5auyexw9x    FK CONSTRAINT     ?   ALTER TABLE ONLY public.book_from_authors
    ADD CONSTRAINT fk330mv2v751ogeiin5auyexw9x FOREIGN KEY (ssn) REFERENCES public.author(ssn);
 W   ALTER TABLE ONLY public.book_from_authors DROP CONSTRAINT fk330mv2v751ogeiin5auyexw9x;
       public          postgres    false    203    206    2715            ?
           2606    33885 )   book_category fkam8llderp40mvbbwceqpu6l2s    FK CONSTRAINT     ?   ALTER TABLE ONLY public.book_category
    ADD CONSTRAINT fkam8llderp40mvbbwceqpu6l2s FOREIGN KEY (category_id) REFERENCES public.category(category_id);
 S   ALTER TABLE ONLY public.book_category DROP CONSTRAINT fkam8llderp40mvbbwceqpu6l2s;
       public          postgres    false    2719    205    207            ?
           2606    33905 "   source fkap24xu0n6y6o7oeqktomysg98    FK CONSTRAINT     ?   ALTER TABLE ONLY public.source
    ADD CONSTRAINT fkap24xu0n6y6o7oeqktomysg98 FOREIGN KEY (sources_book_id) REFERENCES public.book(book_id);
 L   ALTER TABLE ONLY public.source DROP CONSTRAINT fkap24xu0n6y6o7oeqktomysg98;
       public          postgres    false    2717    204    209            ?
           2606    33880     book fkku84943ve4s7xdq8wunk6g2vf    FK CONSTRAINT     ?   ALTER TABLE ONLY public.book
    ADD CONSTRAINT fkku84943ve4s7xdq8wunk6g2vf FOREIGN KEY (publisher_publisher_id) REFERENCES public.publisher(publisher_id);
 J   ALTER TABLE ONLY public.book DROP CONSTRAINT fkku84943ve4s7xdq8wunk6g2vf;
       public          postgres    false    208    2721    204            ?
           2606    33890 )   book_category fknyegcbpvce2mnmg26h0i856fd    FK CONSTRAINT     ?   ALTER TABLE ONLY public.book_category
    ADD CONSTRAINT fknyegcbpvce2mnmg26h0i856fd FOREIGN KEY (book_id) REFERENCES public.book(book_id);
 S   ALTER TABLE ONLY public.book_category DROP CONSTRAINT fknyegcbpvce2mnmg26h0i856fd;
       public          postgres    false    2717    204    205            ?
           2606    33900 ,   book_from_authors fkq9ecy25tvlgbneiml3swrova    FK CONSTRAINT     ?   ALTER TABLE ONLY public.book_from_authors
    ADD CONSTRAINT fkq9ecy25tvlgbneiml3swrova FOREIGN KEY (book_id) REFERENCES public.book(book_id);
 V   ALTER TABLE ONLY public.book_from_authors DROP CONSTRAINT fkq9ecy25tvlgbneiml3swrova;
       public          postgres    false    206    204    2717            )   ?   x???Ak?0?{?ŻU??u???iqcUw??k06????/Qq??\???ZԳ?%T????V????X9?&?U?k6_??4?n????p?a?2_?j?xJ?CDq1M?RP*?ħ?	ϯF?Ƅ?ν6??9??@Q?>
?[ [k?u.?N@?/?'(???'??U????{%$\??Y4?=!i~C??Kw?l兡?#?~։??      *     x??S?n?0??+xKx??E????@??dݱ?-?&"??$7?m?/ܗ????r$?O|z??<m~?`??{??+-W?R? Wy}eS??Xn?/?????
???kxY??????rU?|?aMf?!pl?%??p*??)?M?F?9????4?0????"0?G>AlC?k?.Mo?Ԁ0Aږ샸??!|#???$b?О?.4?XNz?%?s&P?^??؋???cÉ?ƐY?ż????<]kpy????lsYy???????;??,??Dl<?????	??/??w???!??|?aLZ?? ??q???Bj?*?ķ?c-깇?7h?Ⱥ?*?2PJ??
?j??ٓ?W?e????Σkl???1??=D?s.?Z#??@o??Λ?v??G&7A?????k[5?8???^^?U???	??U??S??Bɰ*?"??y&?I??,?T5?*L?u16h	?!?,K?.?????G?VZ;?
?)??'қ??{?V?Q?ց?c???:?'?3*??&?z??|'??#?P?W?f????M??      +   i   x???v
Q???W((M??L?K??ώON,IM?/?T? s3St`B@??B??O?k????????????5?'?F???23??Q??:
???0??h??1?(.. u?^?      ,   {   x???v
Q???W((M??L?K??ώO+?ύO,-??/*V? e??(?i*?9???+h[?(????????????5?'%F??????ɔiha4? ?J ??+-AF????q.. <ba?      -   ?   x???v
Q???W((M??L?KN,IM?/?TЀ??3St?sS5?}B]?4??t?]?s?5??<?6?h?Gfq	P??-L?W&g????Sf??1?,?ļ??b?26?.(?71/9d .2sH      .   q   x???v
Q???W((M??L?S??E
pf|f??BbJJQjq??B^bn??B??O?k?????????#DR!?M?$#U?S(???$????i??I?-??bc2,?? 6?w'      /     x???Qo?0???)?ۤΎ??m@?T?*u+Ѝ?'ˉ???cG>g???q?N?'DyHNq|?????????׻h~{??ڮЪ$h;WBt2D??(Z[???:?GѰ??????????+O?o????Ut??Qt???q???;J7?i???~FUb??????VAzWÛ$?鲆F?'C???b1?O???4Ov1??Z<? ???8???n??B"?h-????????^֮?!???^??>?C??}?Āﻧ?4?mu??.?p???<???|:aǇ???ٯA?l?DB?y6???i?GY5?<3? ??ݗhċ5}?a???9?)7?j)???'9??l?$I??'?_Y̯o6P?|;???!?~g?;B???PQz?gBo?Y8>h??5?F?B??^)h
?????B!???Z?ڷ??-kah?????ʮ?H???Z?R????dgiXe9?L?L????$?/????L5߲?𮃃?K???.?jb]ĭUЏVke?R?0=?Z???????X(g?l?K/??8:?	??I     