class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        
        int n = s1.length();
        if (s1.equals(s2)) {
            return true;
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                count++;
            }
        }
        if (count > 2) {
            return false;
        }
        char[] s1Arr = s1.toCharArray();
        char[] s2Arr = s2.toCharArray();
        Arrays.sort(s1Arr);
        Arrays.sort(s2Arr);
        return Arrays.equals(s1Arr, s2Arr);
    }
}