class Solution {
    public int lengthOfLastWord(String s) {
        
        int len = s.length();
        int lastLen = 0;
        boolean flag = false;
        for(int i = len - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if(c != ' ') {
                lastLen++;
                flag = true;
            } else {
                if(flag) {
                    break;
                }
            }
        }
        return lastLen;
    }
}