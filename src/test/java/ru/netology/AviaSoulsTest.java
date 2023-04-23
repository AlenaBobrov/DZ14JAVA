package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AviaSoulsTest {
    Ticket ticket1 = new Ticket("Домодедово", "Анапа", 4000, 15, 17);
    Ticket ticket2 = new Ticket("Домодедово", "Пхукет", 30000, 10, 22);
    Ticket ticket3 = new Ticket("Домодедово", "Анапа", 3000, 12, 15);
    Ticket ticket4 = new Ticket("Домодедово", "Саратов", 3000, 12, 14);
    Ticket ticket5 = new Ticket("Домодедово", "Мурманск", 14000, 12, 20);
    Ticket ticket6 = new Ticket("Домодедово", "Анапа", 14000, 12, 21);

    @Test
    public void searchCompareToMore() {
        assertEquals(1, ticket2.compareTo(ticket5));
    }

    @Test
    public void searchCompareToLess() {
        assertEquals(-1, ticket3.compareTo(ticket1));
    }

    @Test
    public void searchCompareToEqual() {
        assertEquals(0, ticket3.compareTo(ticket4));
    }

    @Test
    public void searchTest() {
        AviaSouls tick = new AviaSouls();
        tick.add(ticket1);
        tick.add(ticket2);
        tick.add(ticket3);
        tick.add(ticket4);
        tick.add(ticket5);

        Assertions.assertArrayEquals(new Ticket[]{ticket3, ticket1}, tick.search("Домодедово", "Анапа"));
    }

    @Test
    public void emptySearchTest() {
        AviaSouls tick = new AviaSouls();
        tick.add(ticket1);
        tick.add(ticket2);
        tick.add(ticket3);
        tick.add(ticket4);
        tick.add(ticket5);

        Assertions.assertArrayEquals(new Ticket[]{}, tick.search("Шереметьево", "Анапа"));
    }

    @Test
    public void testCompareLess() {
        TicketTimeComparator timeComparator = new TicketTimeComparator();
        assertEquals(-1, timeComparator.compare(ticket1, ticket2));

    }

    @Test
    public void testCompareMore() {
        TicketTimeComparator timeComparator = new TicketTimeComparator();
        assertEquals(1, timeComparator.compare(ticket5, ticket4));

    }

    @Test
    public void testCompareEqual() {
        TicketTimeComparator timeComparator = new TicketTimeComparator();
        assertEquals(0, timeComparator.compare(ticket1, ticket4));

    }

    @Test
    public void comparatorSearchTest() {
        AviaSouls tick = new AviaSouls();
        TicketTimeComparator timeComparator = new TicketTimeComparator();
        tick.add(ticket1);
        tick.add(ticket2);
        tick.add(ticket3);
        tick.add(ticket4);
        tick.add(ticket5);
        tick.add(ticket6);

        Assertions.assertArrayEquals(new Ticket[]{ticket1, ticket3, ticket6}, tick.searchAndSortBy("Домодедово", "Анапа", timeComparator));
    }

    @Test
    public void comparatorSearchTestEmpty() {
        AviaSouls tick = new AviaSouls();
        TicketTimeComparator timeComparator = new TicketTimeComparator();
        tick.add(ticket1);
        tick.add(ticket2);
        tick.add(ticket3);
        tick.add(ticket4);
        tick.add(ticket5);

        Assertions.assertArrayEquals(new Ticket[]{}, tick.searchAndSortBy("Шереметьево", "Анапа", timeComparator));
    }

    @Test
    public void comparatorSearchTestOne() {
        AviaSouls tick = new AviaSouls();
        TicketTimeComparator timeComparator = new TicketTimeComparator();
        tick.add(ticket1);
        tick.add(ticket5);

        Assertions.assertArrayEquals(new Ticket[]{ticket1}, tick.searchAndSortBy("Домодедово", "Анапа", timeComparator));
    }
}
