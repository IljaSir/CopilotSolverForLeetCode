class Solution {
    public String nearestPalindromic(String n) {
        
        int nLen = n.length();
        long nLong = Long.parseLong(n);
        long[] candidates = new long[] {
            (long)Math.pow(10, nLen) + 1,
            (long)Math.pow(10, nLen - 1) - 1,
            (long)Math.pow(10, nLen - 1) + 1,
            (long)Math.pow(10, nLen - 1) - 1
        };
        for (int i = 0; i < candidates.length; i++) {
            if (i == 0) {
                candidates[0] = candidates[0] / 10;
            } else if (i == 1) {
                candidates[1] = candidates[1] / 10;
            } else if (i == 2) {
                candidates[2] = candidates[2] / 10;
            } else if (i == 3) {
                candidates[3] = candidates[3] / 10;
            }
            String s = String.valueOf(candidates[i]);
            StringBuilder sb = new StringBuilder(s);
            sb.reverse();
            candidates[i] = Long.parseLong(s + sb.toString());
        }
        long minDiff = Long.MAX_VALUE;
        long minDiffCandidate = Long.MAX_VALUE;
        for (long candidate : candidates) {
            if (candidate == nLong) {
                continue;
            }
            long diff = Math.abs(candidate - nLong);
            if (diff < minDiff) {
                minDiff = diff;
                minDiffCandidate = candidate;
            } else if (diff == minDiff) {
                minDiffCandidate = Math.min(minDiffCandidate, candidate);
            }
        }
        return String.valueOf(minDiffCandidate);
    }
}