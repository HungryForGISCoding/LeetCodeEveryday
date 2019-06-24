class FlipColumnsForMaximumNumberofEqualRows{
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        
        
        int m=matrix.length;
        int n=matrix[0].length;
        int ans=0;
        int[] flip=new int[n];
        for(int i=0;i<m;i++)
        {
            int tmp=0;
            for(int j=0;j<n;j++)
                flip[j]=1-matrix[i][j];
            for(int j=0;j<m;j++)
            {
                if(Arrays.equals(matrix[i],matrix[j]) || Arrays.equals(matrix[j],flip))
                    tmp++;
            }
            ans=Math.max(ans,tmp);
        }
        return ans;
    }	
}