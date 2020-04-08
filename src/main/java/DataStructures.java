public class DataStructures {
        public static void main(String[] args) {
            int g = 10, z = 10;

            int[][] grid = { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                    { 0, 0, 0, 1, 1, 0, 0, 0, 0, 0 },
                    { 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
                    { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                    { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                    { 0, 0, 0, 1, 1, 0, 0, 0, 0, 0 },
                    { 0, 0, 1, 1, 0, 0, 0, 0, 0, 0 },
                    { 0, 0, 0, 0, 0, 1, 0, 0, 0, 0 },
                    { 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
                    { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }
            };

            System.out.println("Original Generation");
            for (int i = 0; i < g; i++) {
                for (int j = 0; j < z; j++) {
                    if (grid[i][j] == 0)
                        System.out.print("+");
                    else
                        System.out.print("#");
                }
                System.out.println();
            }
            System.out.println();
            nextGeneration(grid, g, z);
        }

        static void nextGeneration(int[][] grid, int g, int z)
        {
            int[][] future = new int[g][z];

            for (int l = 1; l < g - 1; l++) {
                for (int m = 1; m < z - 1; m++) {
                    int aliveNeighbours = 0;
                    for (int i = -1; i <= 1; i++)
                        for (int j = -1; j <= 1; j++)
                            aliveNeighbours += grid[l + i][m + j];
                    aliveNeighbours -= grid[l][m];


                    if ((grid[l][m] == 1) && (aliveNeighbours < 2))
                        future[l][m] = 0;
                    else if ((grid[l][m] == 1) && (aliveNeighbours > 3))
                        future[l][m] = 0;
                    else if ((grid[l][m] == 0) && (aliveNeighbours == 3))
                        future[l][m] = 1;
                    else
                        future[l][m] = grid[l][m];
                }
            }

            System.out.println("Next Generation");
            for (int i = 0; i < g; i++) {
                for (int j = 0; j < z; j++) {
                    if (future[i][j] == 0)
                        System.out.print(".");
                    else
                        System.out.print("*");
                }
                System.out.println();
            }
        }
    }


