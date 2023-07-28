class Solution {
    public int getMaxGridHappiness(int m, int n, int introvertsCount, int extrovertsCount) {
        
        int[][] dp = new int[m][1 << n];
        int[] mask = new int[1 << n];
        for (int i = 0; i < 1 << n; i++) {
            int[] row = new int[n];
            for (int j = 0; j < n; j++) {
                row[j] = (i >> j) & 1;
            }
            for (int j = 0; j < n; j++) {
                if (row[j] == 1) {
                    if (j - 1 >= 0 && row[j - 1] == 1) {
                        mask[i] += 60;
                    }
                    if (j + 1 < n && row[j + 1] == 1) {
                        mask[i] += 60;
                    }
                    if (row[j] == 1) {
                        mask[i] += 40;
                    }
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 1 << n; j++) {
                for (int k = 0; k < 1 << n; k++) {
                    if ((j & k) != 0) {
                        continue;
                    }
                    int[] row = new int[n];
                    for (int l = 0; l < n; l++) {
                        row[l] = (k >> l) & 1;
                    }
                    int cnt = 0;
                    for (int l = 0; l < n; l++) {
                        if (row[l] == 1) {
                            cnt++;
                        }
                    }
                    if (cnt > introvertsCount) {
                        continue;
                    }
                    int cnt2 = 0;
                    for (int l = 0; l < n; l++) {
                        if (row[l] == 0) {
                            cnt2++;
                        }
                    }
                    if (cnt2 > extrovertsCount) {
                        continue;
                    }
                    int val = mask[k];
                    for (int l = 0; l < n; l++) {
                        if (row[l] == 1) {
                            if (l - 1 >= 0 && row[l - 1] == 1) {
                                val -= 30;
                            }
                            if (l +
    }
}