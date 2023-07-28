class Solution {
    public boolean makeStringsEqual(String s, String target) {
        
        int[] a = new int[26];
        for (char c : s.toCharArray()) {
            a[c - 'a']++;
        }
        for (char c : target.toCharArray()) {
            a[c - 'a']--;
        }
        for (int i : a) {
            if (i != 0) return false;
        }
        return true;
    }
}