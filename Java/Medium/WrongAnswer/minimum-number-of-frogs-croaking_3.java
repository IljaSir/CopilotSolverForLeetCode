class Solution {
    public int minNumberOfFrogs(String croakOfFrogs) {
        
        int c = 0;
        int r = 0;
        int o = 0;
        int a = 0;
        int k = 0;
        int frogs = 0;
        for (char ch : croakOfFrogs.toCharArray()) {
            switch (ch) {
                case 'c': {
                    c++;
                    frogs = Math.max(frogs, c);
                    break;
                }
                case 'r': {
                    if (c <= 0) {
                        return -1;
                    }
                    c--;
                    r++;
                    break;
                }
                case 'o': {
                    if (r <= 0) {
                        return -1;
                    }
                    r--;
                    o++;
                    break;
                }
                case 'a': {
                    if (o <= 0) {
                        return -1;
                    }
                    o--;
                    a++;
                    break;
                }
                case 'k': {
                    if (a <= 0) {
                        return -1;
                    }
                    a--;
                    k++;
                    break;
                }
            }
        }
        return frogs == c ? frogs : -1;
    }
}