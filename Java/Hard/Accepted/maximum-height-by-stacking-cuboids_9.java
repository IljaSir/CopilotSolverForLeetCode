class Solution {
    public int maxHeight(int[][] cuboids) {
        
        int n = cuboids.length;
        for(int i = 0; i < n; i++) {
            Arrays.sort(cuboids[i]);
        }
        Arrays.sort(cuboids, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                } else if(o1[1] != o2[1]) {
                    return o1[1] - o2[1];
                } else {
                    return o1[2] - o2[2];
                }
            }
        });
        int[] dp = new int[n];
        int ans = 0;
        for(int i = 0; i < n; i++) {
            dp[i] = cuboids[i][2];
            for(int j = 0; j < i; j++) {
                if(cuboids[j][1] <= cuboids[i][1] && cuboids[j][2] <= cuboids[i][2]) {
                    dp[i] = Math.max(dp[i], dp[j] + cuboids[i][2]);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}