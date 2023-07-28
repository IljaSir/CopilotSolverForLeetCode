class Solution {
    public int minNumberOfFrogs(String croakOfFrogs) {
        
        int c = 0;
        int r = 0;
        int o = 0;
        int a = 0;
        int k = 0;
        int frogs = 0;
        int maxFrogs = 0;
        for (char ch : croakOfFrogs.toCharArray()) {
            switch (ch) {
                case 'c':
                    c++;
                    frogs++;
                    break;
                case 'r':
                    r++;
                    break;
                case 'o':
                    o++;
                    break;
                case 'a':
                    a++;
                    break;
                case 'k':
                    k++;
                    frogs--;
                    break;
            }
            if (c < r || r < o || o < a || a < k) {
                return -1;
            }
            maxFrogs = Math.max(maxFrogs, frogs);
        }
        return c == r && r == o && o == a && a == k ? maxFrogs : -1;
    }
}