class Solution {
    public boolean hasAllCodes(String s, int k) {
        
        if (s.length() < k) {
            return false;
        }
        int max = (int) Math.pow(2, k);
        Set<String> set = new HashSet<>();
        for (int i = 0; i < s.length() - k + 1; i++) {
            String sub = s.substring(i, i + k);
            set.add(sub);
            if (set.size() == max) {
                return true;
            }
        }
        return false;
    }
}