class Solution {
    public int maximumGood(int[][] statements) {
        
        int n = statements.length;
        int ans = 0;
        for (int i = 0; i < (1 << n); i++) {
            boolean[] good = new boolean[n];
            boolean[] bad = new boolean[n];
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) > 0) {
                    good[j] = true;
                } else {
                    bad[j] = true;
                }
            }
            boolean valid = true;
            for (int j = 0; j < n; j++) {
                if (good[j]) {
                    for (int k = 0; k < n; k++) {
                        if (j == k) continue;
                        if (statements[j][k] == 0) {
                            if (good[k]) {
                                valid = false;
                                break;
                            }
                        } else if (statements[j][k] == 1) {
                            if (bad[k]) {
                                valid = false;
                                break;
                            }
                        }
                    }
                } else {
                    for (int k = 0; k < n; k++) {
                        if (j == k) continue;
                        if (statements[j][k] == 0) {
                            if (bad[k]) {
                                valid = false;
                                break;
                            }
                        } else if (statements[j][k] == 1) {
                            if (good[k]) {
                                valid = false;
                                break;
                            }
                        }
                    }
                }
                if (!valid) break;
            }
            if (valid) {
                int cnt = 0;
                for (int j = 0; j < n; j++) {
                    if (good[j]) cnt++;
                }
                ans = Math.max(ans, cnt);
            }
        }
        return ans;
    }
}