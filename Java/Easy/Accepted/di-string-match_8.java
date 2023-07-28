class Solution {
    public int[] diStringMatch(String s) {
        
        int[] res = new int[s.length()+1];
        int min = 0;
        int max = s.length();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == 'I'){
                res[i] = min;
                min++;
            }else{
                res[i] = max;
                max--;
            }
        }
        res[s.length()] = min;
        return res;
    }
}