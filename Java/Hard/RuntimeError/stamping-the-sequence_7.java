class Solution {
    public int[] movesToStamp(String stamp, String target) {
        
        int[] ans = new int[1000];
        int t = 0;
        char[] cs = stamp.toCharArray();
        char[] ct = target.toCharArray();
        boolean[] done = new boolean[ct.length];
        int count = 0;
        while (count < ct.length) {
            boolean found = false;
            for (int i = 0; i <= ct.length - cs.length; i++) {
                if (done[i]) {
                    continue;
                }
                int stars = 0;
                int changed = 0;
                for (int j = 0; j < cs.length; j++) {
                    if (ct[i + j] == '*') {
                        stars++;
                    } else if (ct[i + j] == cs[j]) {
                        changed++;
                    }
                }
                if (stars + changed == cs.length) {
                    for (int j = 0; j < cs.length; j++) {
                        if (ct[i + j] != '*') {
                            ct[i + j] = '*';
                            count++;
                        }
                    }
                    ans[t++] = i;
                    found = true;
                }
            }
            if (!found) {
                return new int[0];
            }
        }
        int[] ret = new int[t];
        for (int i = 0; i < t; i++) {
            ret[i] = ans[t - i - 1];
        }
        return ret;
    }
}