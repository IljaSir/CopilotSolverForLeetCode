class Solution {
    public int shortestSequence(int[] rolls, int k) {
        
        int n = rolls.length;
        int[] count = new int[k + 1];
        int[] maxCount = new int[k + 1];
        int[] minCount = new int[k + 1];
        int[] minCount2 = new int[k + 1];
        int[] maxCount2 = new int[k + 1];
        int[] minCount3 = new int[k + 1];
        int[] maxCount3 = new int[k + 1];
        for (int i = 0; i < n; i++) {
            if (i >= k) {
                count[rolls[i - k]]--;
            }
            count[rolls[i]]++;
            for (int j = 1; j <= k; j++) {
                maxCount[j] = Math.max(maxCount[j], count[j]);
                minCount[j] = Math.min(minCount[j], count[j]);
            }
            if (i >= k - 1) {
                for (int j = 1; j <= k; j++) {
                    maxCount2[j] = Math.max(maxCount2[j], maxCount[j]);
                    minCount2[j] = Math.min(minCount2[j], minCount[j]);
                }
            }
            if (i >= 2 * k - 2) {
                for (int j = 1; j <= k; j++) {
                    maxCount3[j] = Math.max(maxCount3[j], maxCount2[j]);
                    minCount3[j] = Math.min(minCount3[j], minCount2[j]);
                }
            }
        }
        int res = n + 1;
        for (int i = 1; i <= k; i++) {
            for (int j = 1; j <= k; j++) {
                if (i == j) {
                    continue;
                }
                int cur = 0;
                if (minCount3[i] < 0) {
                    cur -= minCount3[i];
                }
                if (maxCount3[i] > 0) {
                    cur += maxCount3[i];
                }
                if (minCount3[j] < 0) {
                    cur -= minCount3[j];
                }
                if (maxCount3[j] > 0) {
                    cur += maxCount3[j];
                }
                res = Math.min(res, cur);
            }
        }
    }
}