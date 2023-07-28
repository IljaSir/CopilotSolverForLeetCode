class Solution {
    public String maximumTime(String time) {
        
        char[] chs = time.toCharArray();
        if (chs[0] == '?') {
            if (chs[1] == '?' || chs[1] <= '3') {
                chs[0] = '2';
            } else {
                chs[0] = '1';
            }
        }
        if (chs[1] == '?') {
            if (chs[0] == '2') {
                chs[1] = '3';
            } else {
                chs[1] = '9';
            }
        }
        if (chs[3] == '?') {
            chs[3] = '5';
        }
        if (chs[4] == '?') {
            chs[4] = '9';
        }
        return new String(chs);
    }
}