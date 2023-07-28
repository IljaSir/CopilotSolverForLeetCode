class Solution {
    public int maxBuilding(int n, int[][] restrictions) {
        
        int len = restrictions.length;
        int[][] res = new int[len+2][2];
        res[0][0] = 1;
        res[0][1] = 0;
        res[len+1][0] = n;
        res[len+1][1] = n-1;
        for(int i=0;i<len;i++){
            res[i+1][0] = restrictions[i][0];
            res[i+1][1] = restrictions[i][1];
        }
        Arrays.sort(res, (a,b)->a[0]-b[0]);
        for(int i=1;i<len+2;i++){
            res[i][1] = Math.min(res[i][1], res[i-1][1]+res[i][0]-res[i-1][0]);
        }
        for(int i=len;i>=0;i--){
            res[i][1] = Math.min(res[i][1], res[i+1][1]+res[i+1][0]-res[i][0]);
        }
        int ans = 0;
        for(int i=1;i<len+2;i++){
            int h = Math.min(res[i][1], res[i-1][1]+(res[i][0]-res[i-1][0]));
            ans = Math.max(ans, h);
        }
        return ans;
    }
}