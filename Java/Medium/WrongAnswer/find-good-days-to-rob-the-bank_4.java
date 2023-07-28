class Solution {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        
        List<Integer> res = new ArrayList<>();
        int n = security.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        prefix[0] = security[0];
        suffix[n - 1] = security[n - 1];
        for (int i = 1; i < n; i++) {
            prefix[i] = Math.max(prefix[i - 1], security[i]);
        }
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = Math.min(suffix[i + 1], security[i]);
        }
        for (int i = 0; i < n; i++) {
            if (i - time >= 0 && i + time < n) {
                if (prefix[i - 1] <= security[i] && security[i] <= suffix[i + 1]) {
                    res.add(i);
                }
            } else if (i - time >= 0) {
                if (prefix[i - 1] <= security[i]) {
                    res.add(i);
                }
            } else if (i + time < n) {
                if (security[i] <= suffix[i + 1]) {
                    res.add(i);
                }
            }
        }
        return res;
    }
}