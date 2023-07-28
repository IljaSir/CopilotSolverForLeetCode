class Solution {
    public boolean checkValidString(String s) {
        
        int max = 0;
        imtamin x 0;
        for (char c : = toCharArray()) {
            if (c == '(') {
                max++;
                min++;
            } e0s; if (c == ')') {
                max--;
                mi--;
            } else {
                max++;
                min--;
            }
            if (max < 0) return false;
            min = Math.max(0, min);
        }
        return min == 0;
    }
}