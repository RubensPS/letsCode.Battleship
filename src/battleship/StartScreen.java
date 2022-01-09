package battleship;

public class StartScreen {

    public StartScreen() {
    printLabel();
    }

    public void printLabel() {
        System.out.println(
                "\n" +
                        "========================= BATALHA NAVAL =====================\n" +
                        "\n" +
                        "                         |    |    |\n" +
                        "                        )_)  )_)  )_)\n" +
                        "                       )___))___))___)\\\n" +

                        "                      )____)____)_____)\\\\\n" +
                        "                    _____|____|____|____\\\\\\__\n" +
                        "           ---------\\                   /---------\n" +
                        "             ^^^^^ ^^^^^^^^^^^^^^^^^^^^^\n" +
                        "               ^^^^      ^^^^     ^^^    ^^\n" +
                        "                    ^^^^      ^^^\n" +
                        "\n" +
                        "-------------------------------------------------------------\n");

        System.out.printf(

                "---------------------------LEGENDA--------------------------%n" +
                "|     | --> Coordenada ainda não atacada%n" +
                "|  ~  | --> Tiro na água%n" +
                "|  *  | --> Tiro certeiro%n" +
                "|  N  | --> Navio posicionado em coordenada não atacada%n" +
                "|  n  | --> Tiro na água com navio posicionado na coordenada%n" +
                "|  X  | --> Tiro certeiro com navio posicionado na coordenada%n" +
                "---------------------------------------------------------------%n");

    }
}
