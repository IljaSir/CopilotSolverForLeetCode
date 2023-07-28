class Solution {
    public int minimumTime(String s) {
        
        int n = s.length();
        int i = 0;
        int j = n - 1;
        int res = 0;
        while(i < j){
            while(i < j && s.charAt(i) == '0') i++;
            while(i < j && s.charAt(j) == '0') j--;
            if(i < j){
                res += 2;
                i++;
                j--;
            }
        }
        if(i == j && s.charAt(i) == '1') res++;
        return res;
    }
}