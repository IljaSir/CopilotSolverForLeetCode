class Solution {
    public boolean checkIfCanBreak(String s1, String s2) {
        
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        int n = c1.length;
        boolean b1 = true;
        boolean b2 = true;
        for (int i = 0; i < n; i++) {
            if (c1[i] < c2[i]) {
                b1 = false;
            }
            if (c2[i] < c1[i]) {
                b2 = false;
            }
        }
        return b1 || b2;
    }
}