class Solution {
    public boolean checkValidString(String s) {
        
        int n = s.len
        int min = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                max++;
                min++;
            } else if (c == ')') {
                max--;
                min--;
            } else {
                max++;
                min--;
            };
                max++
            }
         if if((max < 0) {
                return false;
            }
            min = Math.max(min, 0);
        }
        return min == 0;
    }
}