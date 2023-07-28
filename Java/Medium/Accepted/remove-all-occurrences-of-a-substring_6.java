class Solution {
    public String removeOccurrences(String s, String part) {
        
        int n = s.length();
        int m = part.length();
        int i = 0;
        while(i < n){
            int j = 0;
            while(j < m && i+j < n && s.charAt(i+j) == part.charAt(j)){
                j++;
            }
            if(j == m){
                s = s.substring(0, i) + s.substring(i+j);
                n = s.length();
                i = 0;
            }else{
                i++;
            }
        }
        return s;
    }
}