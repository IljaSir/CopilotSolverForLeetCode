class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        
        int[] metal = new int[garbage.length];
        int[] paper = new int[garbage.length];
        int[] glass = new int[garbage.length];
        int[] sum = new int[garbage.length];
        for (int i = 0; i < garbage.length; i++) {
            for (char c : garbage[i].toCharArray()) {
                switch (c) {
                    case 'M':
                        metal[i]++;
                        break;
                    case 'P':
                        paper[i]++;
                        break;
                    case 'G':
                        glass[i]++;
                        break;
                }
            }
        }
        for (int i = 1; i < garbage.length; i++) {
            sum[i] = sum[i - 1] + travel[i - 1];
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < garbage.length; i++) {
            int m = 0, p = 0, g = 0;
            for (int j = 0; j <= i; j++) {
                m += metal[j];
                p += paper[j];
                g += glass[j];
            }
            if (m == 0 && p == 0 && g == 0) {
                continue;
            }
            int t = sum[i];
            if (m > 0) {
                t += sum[garbage.length - 1] - sum[i];
            }
            if (p > 0) {
                t += sum[garbage.length - 1] - sum[i];
            }
            if (g > 0) {
                t += sum[garbage.length - 1] - sum[i];
            }
            ans = Math.min(ans, t);
        }
        return ans;
    }
}