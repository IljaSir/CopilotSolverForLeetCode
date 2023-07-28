class Solution {
    public boolean canConvertString(String s, String t, int k) {
        
        if(s.length() != t.length()){
            return false;
        }
        int[] shift = new int[26];
        for(int i = 0; i < s.length(); i++){
            int diff = t.charAt(i) - s.charAt(i);
            if(diff < 0){
                diff += 26;
            }
            if(diff != 0){
                shift[diff]++;
            }
        }
        for(int i = 1; i <= k; i++){
            int index = i % 26;
            if(shift[index] > 0){
                shift[index]--;
            }else{
                return false;
            }
        }
        return true;
    }
}