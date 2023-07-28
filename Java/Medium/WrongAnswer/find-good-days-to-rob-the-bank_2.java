class Solution {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        
        int n = security.length;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = security[0];
        right[n-1] = security[n-1];
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(left[i-1], security[i]);
        }
        for (int i = n-2; i >= 0; i--) {
            right[i] = Math.max(right[i+1], security[i]);
        }
        List<Integer> res = new ArrayList<>();
        for (int i = time; i < n-time; i++) {
            boolean isGood = true;
            for (int j = i - time; j < i; j++) {
                if (security[j] > security[j+1]) {
                    isGood = false;
                    break;
                }
            }
            if (isGood) {
                for (int j = i + 1; j <= i + time; j++) {
                    if (security[j] > security[j-1]) {
                        isGood = false;
                        break;
                    }
                }
            }
            if (isGood) res.add(i);
        }
        return res;
    }
}