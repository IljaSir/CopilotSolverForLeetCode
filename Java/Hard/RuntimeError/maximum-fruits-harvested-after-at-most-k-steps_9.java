class Solution {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        
        int ans = 0;
        int n = fruits.length;
        int i = startPos;
        int j = startPos;
        int[] cnt = new int[200001];
        int total = 0;
        while (k-- > 0 && (i >= 0 || j < n)) {
            if (i >= 0 && (j >= n || fruits[i][0] > fruits[j][0])) {
                if (cnt[fruits[i][0]]++ == 0) {
                    total++;
                }
                ans = Math.max(ans, total);
                i--;
            } else {
                if (cnt[fruits[j][0]]++ == 0) {
                    total++;
                }
                ans = Math.max(ans, total);
                j++;
            }
        }
        return ans;
    }
}