PGDMP     6    0                {            beeBeer    15.4    15.4                0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                       1262    16398    beeBeer    DATABASE     �   CREATE DATABASE "beeBeer" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Portuguese_Brazil.1252';
    DROP DATABASE "beeBeer";
                postgres    false            �            1259    24576    telefone_tipo    TABLE     \   CREATE TABLE public.telefone_tipo (
    id_telefone_tipo integer NOT NULL,
    nome text
);
 !   DROP TABLE public.telefone_tipo;
       public         heap    postgres    false            �            1259    24583    usuario    TABLE     �   CREATE TABLE public.usuario (
    id_usuario integer NOT NULL,
    nome text NOT NULL,
    email text NOT NULL,
    senha text NOT NULL
);
    DROP TABLE public.usuario;
       public         heap    postgres    false            �            1259    24588    usuario_telefone    TABLE     �   CREATE TABLE public.usuario_telefone (
    id_usuario integer NOT NULL,
    ddd integer NOT NULL,
    numero_telefone text NOT NULL,
    id_telefone_tipo integer NOT NULL
);
 $   DROP TABLE public.usuario_telefone;
       public         heap    postgres    false            �          0    24576    telefone_tipo 
   TABLE DATA           ?   COPY public.telefone_tipo (id_telefone_tipo, nome) FROM stdin;
    public          postgres    false    214   �       �          0    24583    usuario 
   TABLE DATA           A   COPY public.usuario (id_usuario, nome, email, senha) FROM stdin;
    public          postgres    false    215   T                  0    24588    usuario_telefone 
   TABLE DATA           ^   COPY public.usuario_telefone (id_usuario, ddd, numero_telefone, id_telefone_tipo) FROM stdin;
    public          postgres    false    216   q       m           2606    24582     telefone_tipo telefone_tipo_pkey 
   CONSTRAINT     l   ALTER TABLE ONLY public.telefone_tipo
    ADD CONSTRAINT telefone_tipo_pkey PRIMARY KEY (id_telefone_tipo);
 J   ALTER TABLE ONLY public.telefone_tipo DROP CONSTRAINT telefone_tipo_pkey;
       public            postgres    false    214            o           2606    24587    usuario usuario_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT usuario_pkey PRIMARY KEY (id_usuario);
 >   ALTER TABLE ONLY public.usuario DROP CONSTRAINT usuario_pkey;
       public            postgres    false    215            �   P   x�3�J-�LI�K�L��2�tN�)�I,�2�t��M-��p�%Vp�r�^�����������e��Y��``a`����� ~�      �      x������ � �             x������ � �     