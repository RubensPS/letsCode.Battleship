package battleship;

public class PrintBoard {

    public PrintBoard() {
    }

    public void printBoard(Board board) {
        System.out.println("-----------------------------------------------------------------");
        System.out.println("                            PLAYER");
        System.out.println("-----------------------------------------------------------------");
        System.out.printf("|   |  0  |  1  |  2  |  3  |  4  |  5  |  6  |  7  |  8  |  9  |%n");
        System.out.println("-----------------------------------------------------------------");


        for (int i = 0; i < board.maxRow; i++) {
            System.out.printf("| %s ", RowTag.values()[i]);
            for (int j = 0; j < board.maxColumn; j++) {
                System.out.printf("| %s ", board.getCell(i, j).getSymbol());
            }
            System.out.println("|");
            System.out.println("-----------------------------------------------------------------");
        }

    }
}
