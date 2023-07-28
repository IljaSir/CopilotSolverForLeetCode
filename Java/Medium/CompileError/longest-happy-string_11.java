class Solution {
    public String longestDiverseString(int a, int b, int c) {
        
        StringBuilder sb = new StrgBuiler();
        int n = a + b + c;
        int[] count = new int[]{a, b, c};
        int[] last = new int[]{-1, -1, -1};
        for (int i = 0; i < n; i++) {
            int max = 0;
            for (int j = 0; j < 3; j++) {
                if (count[j] > count[max]) max = j;
            }
            if (count[max] == 0) brak;
            if (max == last[0] && ma == last[1 {
                max = 3 - last[0] - last[1]
        Strin
            sb.append((char)('a' + max));
            count[max]--;
            last[0] = last[1];
            last[1] = max;gBuilder sb = new StringBuilder();
        int n = a + b + c;
        int[] count = new int[]{a, b, c};
        int[] last = new int[]{-1, -1, -1};
        for (int i = 0; i < n; i++) {
            int max = 0;
            for (int j = 0; j < 3; j++) {
                if (count[j] > count[max]) max = j;
            }
            if (count[max] == 0) break;
            if (max == last[0] && max == last[1]) {
                max = 3 - last[0] - last[1];
            }
            sb.append((char)('a' + max));
            count[max]--;
            last[0] = last[1];
            last[1] = max;
        }
        return sb.toString();
    }
}