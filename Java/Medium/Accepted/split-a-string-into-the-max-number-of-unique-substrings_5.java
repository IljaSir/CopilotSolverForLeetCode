class Solution {
    public int maxUniqueSplit(String s) {
        
        return maxUniqueSplit(s, 0, new HashSet<String>());
    }
    private int maxUniqueSplit(String s, int start, Set<String> seen) {
        if (start == s.length()) {
            return 0;
        }
        int max = 0;
        for (int i = start + 1; i <= s.length(); i++) {
            String sub = s.substring(start, i);
            if (!seen.contains(sub)) {
                seen.add(sub);
                max = Math.max(max, 1 + maxUniqueSplit(s, i, seen));
                seen.remove(sub);
            }
        }
        return max;
    }
}