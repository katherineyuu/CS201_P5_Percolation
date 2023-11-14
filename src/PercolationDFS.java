import java.util.*;
public class PercolationDFS extends PercolationDefault {

    public PercolationDFS(int n) {
        super(n);
    }

    public void search(int row, int col) {
        if (!isOpen(row, col)) {
            return;
        }
		Stack <int[]> stack = new Stack<>();
        int[] rowDelta = {-1, 1, 0, 0};
        int[] colDelta = {0, 0, -1, 1};
        myGrid[row][col] = FULL;
        stack.push(new int[] {row, col});

        while (stack.size() != 0) {
            int[] coords = stack.pop();
            for (int k = 0; k < rowDelta.length; k++) {
                row = coords[0] + rowDelta[k];
                col = coords[1] + colDelta[k];
                if (inBounds(row,col) && isOpen(row, col)) {
                    myGrid[row][col] = FULL;
                    stack.push(new int[] {row, col});
                }
            }
        }
	}
}