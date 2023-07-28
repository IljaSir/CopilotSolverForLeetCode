class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        
        if(s1.equals(s2)) return true;
        int i = 0;
        int j = -1;
        int k = -1;
        while(i<s1.length()){
            if(s1.charAt(i) != s2.charAt(i)){
                if(j<0) j = i;
                else if(k<0) k = i;
                else return false;
            }
            i++;
        }
        if(j<0 || k<0) return false;
        return s1.charAt(j) == s2.charAt(k) && s1.charAt(k) == s2.charAt(j);
    }
}