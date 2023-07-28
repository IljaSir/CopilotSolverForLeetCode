class Solution {
    public int[] constructDistancedSequence(int n) {
        
        int[] ans = new int[2 * n - 1];
        int[] count = new int[n + 1];
        Arrays.fill(count, 2);
        count[1] = 1;
        dfs(ans, count, 0);
        return ans;
    }

    private boolean dfs(int[] ans, int[] count, int index) {
        if (index == ans.length) {
            return true;
        }
        if (ans[index] != 0) {
            return dfs(ans, count, index + 1);
        }
        for (int i = count.length - 1; i > 0; i--) {
            if (count[i] > 0) {
                if (i == 1 || index + i < ans.length && ans[index + i] == 0) {
                    ans[index] = i;
                    if (i > 1) {
                        ans[index + i] = i;
                    }
                    count[i]--;
                    if (dfs(ans, count, index + 1)) {
                        return true;
                    }
                    ans[index] = 0;
                    if (i > 1) {
                        ans[index + i] = 0;
                    }
                    count[i]++;
                }
            }
        }
        return false;
    }
}