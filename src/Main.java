import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (true) {
            String prim = calc(scan.nextLine());
            System.out.println(prim);
        }
    }

    public static String calc(String input) {
        String[]prim = input.split(" ", 3);
            boolean found = false;
            boolean found2 = false;
            try {
                for (Rome x : Rome.values()) {
                    if (x.toString().equals(prim[0])) {
                        found = true;
                        break;
                    }
                }
                    for (Rome y : Rome.values()) {
                        if (y.toString().equals(prim[2])) {
                            found2 = true;
                            break;
                        }
                    }
                    if (found && found2) {
                        int num = Rome.valueOf(prim[0]).getArabian();
                        int num2 = Rome.valueOf(prim[2]).getArabian();
                        if (num > 10 || num2 > 10) {
                            input = "Числа больше 10ти нельзя";
                        } else {
                            int answer = calculate(num, prim[1], num2);
                            if(answer <= 0){
                                input = "в римской системе нет отрицательных чисел";
                            }
                            else {
                                input = String.valueOf(Rome.getName(answer));
                            }
                        }
                    } else if (!found && !found2) {
                        int num = Integer.parseInt(prim[0]);
                        int num2 = Integer.parseInt(prim[2]);
                        if (num > 10 || num2 > 10) {
                            input = "Числа больше 10ти нельзя";
                        } else {
                            input = Integer.toString(calculate(num, prim[1], num2));
                        }
                    }
                    else {
                        input = "используются одновременно разные системы счисления";
                    }
                }
            catch (NumberFormatException e){
                input = "формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)";
            }
            catch (ArrayIndexOutOfBoundsException e){
                input = "строка не является математической операцией";
            }
        return input;
    }
    public static int calculate (int num, String oper , int num2) {

        return switch (oper) {
            case "+" -> (num + num2);
            case "*" -> (num * num2);
            case "/" -> (num / num2);
            case "-" -> (num - num2);
            default -> -100;
        };
    }
}