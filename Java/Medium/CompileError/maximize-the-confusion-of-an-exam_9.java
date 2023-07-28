class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        
        int n = answerKey.length();
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        int[] prefixF = new int[n];
        int[] suffixF = new int[n];
        int[] prefixT = new int[n];
        int[] suffixT = new int[n];
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (i > 0) {
                prefix[i] = prefix[i - 1];
                prefixF[i] = prefixF[i - 1];
                prefixT[i] = prefixT[i - 1];
            }
            if (answerKey.charAt(i) == 'F') {
                prefix[i]++;
                prefixF[i]++;
            } else {
                prefixT[i]++;
            }
            res = Math.max(res, prefix[i]);
        }
        for (int i = n - 1; i >= 0; i--) {
            if (i < n - 1) {
                suffix[i] = suffix[i + 1];
                suffixF[i] = suffixF[i + 1];
                suffixT[i] = suffixT[i + 1];
            }
            if (answerKey.charAt(i) == 'F') {
                suffix[i]++;
                suffixF[i]++;
            } else {
                suffixT[i]++;
            }
            res = Math.max(res, suffix[i]);
        }
        for (int i = 0; i < n; i++) {
            int cur = 0;
            int curF = 0;
            int curT = 0;
            if (i > 0) {
                cur = prefix[i - 1];
                curF = prefixF[i - 1];
                curT = prefixT[i - 1];
            }
            if (i < n - 1) {
                cur += suffix[i + 1];
                curF += suffixF[i + 1];
                curT += suffixT[i + 1];
            }
            if (answerKey.charAt(i) == 'F') {
                curF++;
            } else {
                curT++;
            }
            if (answerKey.charAt(i) == 'F') {
                cur += Math.min(k, curT);
            } else {
                cur += Math.min(k, curF);
            }
            res = Math.max(res, cur);
        }
    }
}