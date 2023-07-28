class Solution {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        
        int n = security.length;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = security[0];
        right[n - 1] = security[n - 1];
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(left[i - 1], security[i]);
            right[n - 1 - i] = Math.max(right[n - i], security[n - 1 - i]);
        }
        List<Integer> res = new ArrayList<>();
        for (int i = time; i < n - time; i++) {
            if (left[i - time] >= security[i] && right[i + time] >= security[i]) {
                res.add(i);
            }
        }
        return res;
    }
}