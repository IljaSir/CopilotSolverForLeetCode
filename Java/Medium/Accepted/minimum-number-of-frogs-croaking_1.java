class Solution {
    public int minNumberOfFrogs(String croakOfFrogs) {
        
        int c = 0;
        int r = 0;
        int o = 0;
        int a = 0;
        int k = 0;
        int frogs = 0;
        int max = 0;
        for (char ch: croakOfFrogs.toCharArray()) {
            if (ch == 'c') {
                c++;
                frogs++;
            } else if (ch == 'r') {
                r++;
            } else if (ch == 'o') {
                o++;
            } else if (ch == 'a') {
                a++;
            } else if (ch == 'k') {
                k++;
                frogs--;
            }
            if (c < r || r < o || o < a || a < k) {
                return -1;
            }
            max = Math.max(max, frogs);
        }
        if (c != r || r != o || o != a || a != k) {
            return -1;
        }
        return max;
    }
}