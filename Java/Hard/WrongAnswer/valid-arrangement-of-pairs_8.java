class Solution {
    public int[][] validArrangement(int[][] pairs) {
        
        int[][] ans = new int[pairs.length][2];
        int i = 0;
        for(int[] p: pairs){
            if(p[0] < p[1]){
                ans[i][0] = p[0];
                ans[i][1] = p[1];
            } else {
                ans[i][0] = p[1];
                ans[i][1] = p[0];
            }
            i++;
        }
        Arrays.sort(ans, (a, b) -> {
            if(a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });
        return ans;
    }
}