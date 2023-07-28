class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        
        if(s1.equals(s2)) return true;
        int n = s1.length();
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        int[] diff = new int[2];
        int count = 0;
        for(int i = 0; i < n; i++) {
            if(c1[i] != c2[i]) {
                if(count == 2) return false;
                diff[count++] = i;
            }
        }
        if(count == 1) return false;
        return c1[diff[0]] == c2[diff[1]] && c1[diff[1]] == c2[diff[0]];
    }
}