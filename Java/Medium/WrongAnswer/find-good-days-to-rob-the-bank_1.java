class Solution {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        
        int n = security.length;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = security[0];
        right[n - 1] = security[n - 1];
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(left[i - 1], security[i]);
        }
        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], security[i]);
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int l = i - time;
            int r = i + time;
            boolean ok = true;
            if (l >= 0 && left[l] < security[i]) {
                ok = false;
            }
            if (r < n && right[r] < security[i]) {
                ok = false;
            }
            if (ok) {
                ans.add(i);
            }
        }
        return ans;
    }
}