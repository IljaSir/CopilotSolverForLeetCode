class Solution {
    public int countAsterisks(String s) {
        
        int count = 0;
        int len = s.length();
        for(int i = 0; i < len; i++){
            if(s.charAt(i) == '*')
                count++;
        }
        return count - (len - 1)/2;
    }
}