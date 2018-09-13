package com.examples.dmozo.cardview.utils;

import com.examples.dmozo.cardview.R;

public class DbUtilities {

    //*************CONSTANTS****************
    public static final String TABLE_PRODUCTS_NAME = "PRODUCTS";
    public static final String DB_NAME = "DB_TROPICO";
    public static final String ROW_NAME = "PRODUCT_NAME";
    public static final String ROW_ID = "ID";
    public static final String ROW_PRICE = "PRICE";
    public static final String ROW_IMAGE = "IMAGE";

    //**************QUERIES******************
    public static final String CREATE_TABLE_PRODUCTS = "CREATE TABLE " + TABLE_PRODUCTS_NAME +
            " ("+ROW_ID+" INTEGER,"+ROW_NAME+" TEXT,"+ROW_PRICE+" INTEGER,"+ROW_IMAGE+" TEXT)";
    public static final String DROP_TABLE_PRODUCTS = "DROP TABLE IF EXISTS" + TABLE_PRODUCTS_NAME;
    public static final String SELECT_TABLE_PRODUCTS = "SELECT "+ROW_ID+","+ROW_NAME+","+ROW_PRICE+","+ROW_IMAGE+" FROM" + TABLE_PRODUCTS_NAME;
    public static final String INSERT_PRODUCTS = "INSERT INTO "+TABLE_PRODUCTS_NAME+" ("+ROW_ID+","+ROW_NAME+","+ROW_PRICE+","+ROW_IMAGE+")" +
            "VALUES (1, Yogurt en bolsita 100 grs x 12, 4500,"+ R.drawable.ic_class_black_24dp +"),"+
            "(2, Yogurt en bolsita 180 grs x 6, 3600,"+ R.drawable.ic_class_black_24dp +"),"+
            "(3, Yogurt en bolsa 1 Litro, 3400,"+ R.drawable.ic_class_black_24dp +"),"+
            "(4, Yogurt en vasito 150 grs, 750,"+ R.drawable.ic_class_black_24dp +"),"+
            "(5, Yogurt probiótico 150 grs, 1050,"+ R.drawable.ic_class_black_24dp +"),"+
            "(6, Yogurt ligero 150 grs, 850,"+ R.drawable.ic_class_black_24dp +"),"+
            "(7, Yogurt garrafa 1750 grs, 8700,"+ R.drawable.ic_class_black_24dp +"),"+
            "(8, Yogurt ligero 1750 grs, 9200,"+ R.drawable.ic_class_black_24dp +"),"+
            "(9, Yofrut 120 grs, 1050,"+ R.drawable.ic_class_black_24dp +"),"+
            "(10, Bonfrut probióticos + fibra 170 grs , 1600,"+ R.drawable.ic_class_black_24dp +"),"+
            "(11, Bonfrut cereales y fruta 135 grs, 1210,"+ R.drawable.ic_class_black_24dp +"),"+
            "(12, Kumis 150 grs, 800,"+ R.drawable.ic_class_black_24dp +"),"+
            "(13, Gelatina vasito 120 grs, 900,"+ R.drawable.ic_class_black_24dp +"),"+
            "(14, Gelatina postre vasito 120 grs, 1050,"+ R.drawable.ic_class_black_24dp +"),"+
            "(15, Arequipe 50 grs x 6, 4050,"+ R.drawable.ic_class_black_24dp +"),"+
            "(16, Arequipe 250 grs, 2900,"+ R.drawable.ic_class_black_24dp +"),"+
            "(17, Arequipe 500 grs, 4700,"+ R.drawable.ic_class_black_24dp +"),"+
            "(18, Arequipe taza 1 kg, 7900,"+ R.drawable.ic_class_black_24dp +"),"+
            "(19, Arequipe galón 5 kg, 36000,"+ R.drawable.ic_class_black_24dp +"),"+
            "(20, Mantequilla, 69000,"+ R.drawable.ic_class_black_24dp +"),"+
            "(21, Tropigeli 80 grs x 18, 4100,"+ R.drawable.ic_class_black_24dp +"),"+
            "(22, Refresco de agua bolsa 120 cc x12, 3300,"+ R.drawable.ic_class_black_24dp +"),"+
            "(23, Refresco de agua bolsa 200 cc x6, 2400,"+ R.drawable.ic_class_black_24dp +"),"+
            "(24, Refresco de agua vaso 260 cc, 600,"+ R.drawable.ic_class_black_24dp +"),"+
            "(25, Fresco 270 ml, 850,"+ R.drawable.ic_class_black_24dp +"),"+
            "(26, TropiCream, 850,"+ R.drawable.ic_class_black_24dp +"),"+
            "(27, Arequipe café 50 grs x6, 4050,"+ R.drawable.ic_class_black_24dp +"),"+
            "(28, Arequipe café 250 grs, 3300,"+ R.drawable.ic_class_black_24dp +"),"+
            "(29, Garrafa 750 ml, 4500,"+ R.drawable.ic_class_black_24dp +")";
}
