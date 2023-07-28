class Solution {
    public int maxUniqueSplit(String s) {
        
        return maxUniqueSplit(s, 0, new HashSet<>());
    }
    private int maxUniqueSplit(String s, int start, Set<String> set) {
        if (start == s.length()) {
            return 0;
        }
        int res = 0;
        for (int i = start; i < s.length(); i++) {
            String sub = s.substring(start, i + 1);
            if (!set.contains(sub)) {
                set.add(sub);
                res = Math.max(res, maxUniqueSplit(s, i + 1, set) + 1);
                set.remove(sub);
            }
        }
        return res;
    }
}