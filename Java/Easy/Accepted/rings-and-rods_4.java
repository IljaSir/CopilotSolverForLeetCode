class Solution {
    public int countPoints(String rings) {
        
        int count = 0;
        int[] r = new int[10];
        int[] g = new int[10];
        int[] b = new int[10];
        for (int i = 0; i < rings.length(); i += 2) {
            int rod = rings.charAt(i + 1) - '0';
            switch (rings.charAt(i)) {
                case 'R':
                    r[rod]++;
                    break;
                case 'G':
                    g[rod]++;
                    break;
                case 'B':
                    b[rod]++;
                    break;
            }
        }
        for (int i = 0; i < 10; i++) {
            if (r[i] > 0 && g[i] > 0 && b[i] > 0) {
                count++;
            }
        }
        return count;
    }
}