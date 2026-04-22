package ru.job4j.ood.isp.menu;

public class Printer implements MenuPrinter{
    private static final String INDENT = "----";

    @Override
    public void print(Menu menu) {
        for (Menu.MenuItemInfo item : menu) {
            int dotsCount = 0;
            String number = item.getNumber();
            for (int i = 0; i < number.length(); i++) {
                if (number.charAt(i) == '.') {
                    dotsCount++;
                }
            }
            String prefix = INDENT.repeat(Math.max(0, dotsCount - 1));
            System.out.println(prefix + item.getNumber() + item.getName());
        }
    }

}