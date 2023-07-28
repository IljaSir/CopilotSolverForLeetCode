class Solution {
    public boolean hasAllCodes(String s, int k) {
        
        int len = s.length();
        if (len < k) return false;
        int max = 1 << k;
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < len - k + 1; i++) {
            String sub = s.substring(i, i + k);
            set.add(sub);
            if (set.size() == max) return true;
        }
        return false;
    }
}