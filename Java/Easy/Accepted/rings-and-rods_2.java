class Solution {
    public int countPoints(String rings) {
        
        int n = rings.length() / 2;
        int[] r = new int[10];
        int[] g = new int[10];
        int[] b = new int[10];
        for (int i = 0; i < n; i++) {
            char c = rings.charAt(i * 2);
            int j = rings.charAt(i * 2 + 1) - '0';
            if (c == 'R') {
                r[j]++;
            } else if (c == 'G') {
                g[j]++;
            } else {
                b[j]++;
            }
        }
        int count = 0;
        for (int i = 0; i < 10; i++) {
            if (r[i] > 0 && g[i] > 0 && b[i] > 0) {
                count++;
            }
        }
        return count;
    }
}