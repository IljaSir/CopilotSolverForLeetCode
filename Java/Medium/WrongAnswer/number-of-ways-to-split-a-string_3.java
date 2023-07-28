class Solution {
    public int numWays(String s) {
        
        int total = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                total++;
            }
        }
        if (total == 0) {
            return (int) (((long) s.length() - 1) * (s.length() - 2) / 2 % 1000000007);
        }
        if (total % 3 != 0) {
            return 0;
        }
        int count = 0;
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                count++;
                if (count == total / 3 + 1) {
                    index = i;
                    break;
                }
            }
        }
        int count2 = 0;
        int index2 = 0;
        for (int i = index; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                count2++;
                if (count2 == total / 3 + 1) {
                    index2 = i;
                    break;
                }
            }
        }
        return (int) ((long) (index2 - index) * (index2 - index + 1) / 2 % 1000000007);
    }
}