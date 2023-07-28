class Solution {
    public int minNumberOfFrogs(String croakOfFrogs) {
        
        int c = 0, r = 0, o = 0, a = 0, k = 0;
        int max = 0;
        for (char ch : croakOfFrogs.toCharArray()) {
            if (ch == 'c') {
                c++;
            } else if (ch == 'r') {
                r++;
            } else if (ch == 'o') {
                o++;
            } else if (ch == 'a') {
                a++;
            } else {
                k++;
            }
            max = Math.max(max, c);
            if (r > c || o > r || a > o || k > a) {
                return -1;
            }
        }
        return c == r && r == o && o == a && a == k ? max : -1;
    }
}