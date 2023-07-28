class Solution {
    public boolean hasAllCodes(String s, int k) {
        
        int N = s.length();
        if (N < k) return false;
        Set<String> set = new HashSet<>();
        for (int i = 0; i <= N - k; i++) {
            String sub = s.substring(i, i + k);
            set.add(sub);
        }
        return set.size() == (1 << k);
    }
}