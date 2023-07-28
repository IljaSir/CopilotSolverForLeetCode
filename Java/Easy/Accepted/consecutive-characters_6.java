class Solution {
    public int maxPower(String s) {
        
        int max = 1;
        int current = 1;
        for(int i=1; i<s.length(); i++){
            if(s.charAt(i) == s.charAt(i-1)){
                current++;
            }else{
                current = 1;
            }
            max = Math.max(current, max);
        }
        return max;
    }
}