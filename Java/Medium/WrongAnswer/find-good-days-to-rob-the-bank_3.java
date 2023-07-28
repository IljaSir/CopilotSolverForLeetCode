class Solution {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        
        int n = security.length;
        int[] pre = new int[n];
        int[] post = new int[n];
        pre[0] = security[0];
        post[n - 1] = security[n - 1];
        for (int i = 1; i < n; ++i) {
            pre[i] = Math.max(pre[i - 1], security[i]);
        }
        for (int i = n - 2; i >= 0; --i) {
            post[i] = Math.min(post[i + 1], security[i]);
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            if (i - time >= 0 && i + time < n && pre[i - time] <= security[i] && post[i + time] >= security[i]) {
                ans.add(i);
            }
        }
        return ans;
    }
}