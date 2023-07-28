class Solution {
    public boolean canBeValid(String s, String locked) {
        
        int n = s.length();
        char[] cs = s.toCharArray();
        char[] cl = locked.toCharArray();
        int[] count = new int[2];
        for (int i = 0; i < n; i++) {
            count[cs[i] - '0']++;
            if (cl[i] == '1') {
                count[cs[i] - '0']--;
            }
        }
        return count[0] == count[1] && check(cs, cl);
    }

    private boolean check(char[] cs, char[] cl) {
        int n = cs.length;
        int[] count = new int[2];
        for (int i = 0; i < n; i++) {
            count[cs[i] - '0']++;
            if (cl[i] == '1') {
                count[cs[i] - '0']--;
            }
            if (count[0] < count[1]) {
                return false;
            }
        }
        return count[0] == count[1];
    }
}