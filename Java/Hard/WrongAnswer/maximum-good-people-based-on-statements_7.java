class Solution {
    public int maximumGood(int[][] statements) {
        
        int result = 0;
        int n = statements.length;
        for (int i = 0; i < (1 << n); i++) {
            int[] count = new int[n];
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) > 0) {
                    count[j]++;
                }
            }
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (statements[j][k] == 0) {
                        if (count[j] > 0 && count[k] == 0) {
                            count[k]++;
                        }
                    }
                    if (statements[j][k] == 1) {
                        if (count[j] > 0 && count[k] > 0) {
                            count[k]++;
                        }
                    }
                }
            }
            boolean valid = true;
            for (int j = 0; j < n; j++) {
                if (count[j] == 0) {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                int cur = 0;
                for (int j = 0; j < n; j++) {
                    if (count[j] > 0) {
                        cur++;
                    }
                }
                result = Math.max(result, cur);
            }
        }
        return result;
    }
}