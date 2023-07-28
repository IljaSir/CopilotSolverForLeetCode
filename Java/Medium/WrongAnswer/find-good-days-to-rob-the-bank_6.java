class Solution {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        
        List<Integer> res = new ArrayList<>();
        int n = security.length;
        int[] max = new int[n];
        int[] min = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                max[i] = security[i];
                min[i] = security[i];
            } else {
                max[i] = Math.max(max[i - 1], security[i]);
                min[i] = Math.min(min[i - 1], security[i]);
            }
        }
        for (int i = 0; i < n; i++) {
            if (i - time >= 0 && i + time < n) {
                if (min[i] >= max[i - time] && max[i] <= min[i + time]) {
                    res.add(i);
                }
            } else if (i - time >= 0) {
                if (min[i] >= max[i - time]) {
                    res.add(i);
                }
            } else if (i + time < n) {
                if (max[i] <= min[i + time]) {
                    res.add(i);
                }
            }
        }
        return res;
    }
}