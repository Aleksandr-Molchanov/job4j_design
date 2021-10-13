package ru.job4j.ood.lsp;

/**
 * Класс Box - это хранилище денег,
 * класс ATM - это банкомат, в котором есть хранилище денег,
 * класс SberATM - конкретный банкомат сбера. В сеттере этого класса
 * забыли сделать проверку на валидность.
 * Таким образом операция по снятию денег с банкомата,
 * учитывая что снимаемая сумма, больше той, что доступна,
 * станет возможной.
 * Ошибка в том, что не соблюдено условие класса-предка
 */
public class Example3 {

    private static class Box {

        private float money;

        public Box(float money) {
            this.money = money;
        }

        public float getMoney() {
            return money;
        }
    }

    private static class ATM {

        protected Box box;

        public ATM(Box box) {
            validate(box);
            this.box = box;
        }

        protected void validate(Box box) {
            if (box.getMoney() < 0) {
                throw new IllegalArgumentException("Сумма не может быть отрицательной");
            }
        }

        public void setBox(Box box) {
            validate(box);
            this.box = box;
        }
    }

    private static class SberATM extends ATM {

        public SberATM(Box box) {
            super(box);
        }

        @Override
        public void setBox(Box box) {
            this.box = box;
        }
    }

    public static void main(String[] args) {
        ATM sberATM = new SberATM(new Box(500));
        sberATM.setBox(new Box(-100));
    }

}
