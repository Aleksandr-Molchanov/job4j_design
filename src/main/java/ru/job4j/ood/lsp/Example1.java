package ru.job4j.ood.lsp;

/**
 * В этом примере есть класс Shop (Магазин в котором можно совершить покупку,
 * если человеку исполнилось 6 лет).
 * Так же есть класс AlcoholShop, наследник класса Shop (Магазин в котором можно совершить покупку,
 * если человеку исполнилось 18 лет).
 * Ошибка в том, что предусловие усилено в классе-наследнике.
 */
public class Example1 {

    private static class Shop {

        public boolean isPurchase(int age) {
            if (age < 6) {
                throw new IllegalArgumentException("Человеку нет 6-ти лет");
            }
            return true;
        }
    }

    private static class AlcoholShop extends Shop {

        @Override
        public boolean isPurchase(int age) {
            if (age < 18) {
                throw new IllegalArgumentException("Человек не совершеннолетний");
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Shop shop = new AlcoholShop();
        shop.isPurchase(16);
    }

}
