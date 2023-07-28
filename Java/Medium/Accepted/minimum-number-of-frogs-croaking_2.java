class Solution {
    public int minNumberOfFrogs(String croakOfFrogs) {
        
        int c = 0, r = 0, o = 0, a = 0, k = 0, frogs = 0, maxFrogs = 0;
        for (char ch : croakOfFrogs.toCharArray()) {
            switch (ch) {
                case 'c':
                    c++;
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
                    break;
            }
            if (c < r || r < o || o < a || a < k) return -1;
            if (ch == 'c') frogs++;
            if (ch == 'k') frogs--;
            maxFrogs = Math.max(maxFrogs, frogs);
        }
        if (c != r || r != o || o != a || a != k) return -1;
        return maxFrogs;
    }
}