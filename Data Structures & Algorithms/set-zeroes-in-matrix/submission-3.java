class Solution {
    public void setZeroes(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        int col0=1;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0){
                    // Current row ko 0 mark karo
                    matrix[i][0]=0;
                    // Current col ko 0 mark karo(agar 0th col hai toh col0 variable use karo)
                    if(j!=0){
                        matrix[0][j]=0;
                    }else{
                        col0=0;
                    }
                }
            }
        }
        for(int i=m-1;i>=1;i--){
            for(int j=n-1;j>=1;j--){
                if(matrix[i][0]==0 || matrix[0][j]==0){
                    matrix[i][j]=0;
                }
            }
        }
        // Step 3: Pehli row ko update karo agar zarurat ho
        if(matrix[0][0]==0){
            for(int j=0;j<n;j++){
                matrix[0][j]=0;
            }
        }
        // Step 4: Pehle column ko update karo agar col0 == 0 hai
        if(col0==0){
            for(int i=0;i<m;i++){
                matrix[i][0]=0;
            }
        }
    }
}
