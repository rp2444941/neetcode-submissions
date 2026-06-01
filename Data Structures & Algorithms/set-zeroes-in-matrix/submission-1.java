class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int col0 = 1;

        // Step 1: Scan and set row, col markers
        for (int i = 0; i < m; i++) { // <-- i <= m ko i < m kiya
            for (int j = 0; j < n; j++) { // <-- j <= n ko j < n kiya
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0; // Row marker

                    if (j != 0) {
                        matrix[0][j] = 0; // Col marker
                    } else {
                        col0 = 0;
                    }
                }
            }
        }

        // Step 2: Inner matrix ko markers dekh kar 0 karo
        for (int i = m - 1; i >= 1; i--) {
            for (int j = n - 1; j >= 1; j--) {
                // matrix[0][i] ko badal kar matrix[0][j] kiya
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0; // <-- m ko badal kar 0 kiya
                }
            }
        }

        // Step 3: Pehli row ko khud update karo
        if (matrix[0][0] == 0) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0; // <-- 1 ko badal kar j kiya
            }
        }

        // Step 4: Pehle column ko khud update karo
        if (col0 == 0) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0; // <-- 1 ko badal kar i kiya
            }
        }
    }
}
