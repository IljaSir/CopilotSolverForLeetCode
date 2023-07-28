class Solution {
    public boolean checkValidString(String s) {
        
        int min = 0,  = 0;
        for(char c :s.toCharArray()) {
            if(c == '(') {
                min++;
                max++;
            } else if(c == ')') {
                min--;
                max--;
            } else {
                min--;
                max++;
            }
            if(max 
        return min == 0;
    }
}