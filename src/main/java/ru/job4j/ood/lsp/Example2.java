package ru.job4j.ood.lsp;

/**
 * В этом примере есть класс Director (Директор компании,
 * у которого предусмотрены переработанные часы,
 * за которые к з/п добавляется двойная почасовая ставка,
 * за каждый переработанный час).
 * Так же есть класс DeputyDirector, наследник класса Director
 * (Заместитель директора.
 * В переработанном времени этого сотрудника компания не нуждается,
 * по-этому никогда не просит перерабатывать.
 * Так как отработанных часов не может быть больше 40, то постусловие
 * в блоке if не используется).
 * Ошибка в том, что постусловие ослаблено в классе-наследнике.
 */
public class Example2 {

    private static class Director {

        public float getSalary(float hourlyRate, int hour) {
            float rsl;
            rsl = hourlyRate * hour;
            if (hour > 40) {
                rsl += (hour - 40) * hourlyRate;
            }
            return rsl;
        }
    }

    private static class DeputyDirector extends Director {

        @Override
        public float getSalary(float hourlyRate, int hour) {
            float rsl = 0;
            rsl = hourlyRate * hour;
            return rsl;
        }
    }

    public static void main(String[] args) {
        Director deputyDirector = new DeputyDirector();
        deputyDirector.getSalary(10000, 50);
    }

}