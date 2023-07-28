class Solution {
    public int maxUniqueSplit(String s) {
        
        return maxUniqueSplit(s, 0, new HashSet<String>());
    }
    
    private int maxUniqueSplit(String s, int start, Set<String> set) {
        if (start == s.length()) {
            return 0;
        }
        
        int max = 0;
        for (int i = start; i < s.length(); i++) {
            String sub = s.substring(start, i + 1);
            if (set.contains(sub)) {
                continue;
            }
            set.add(sub);
            max = Math.max(max, 1 + maxUniqueSplit(s, i + 1, set));
            set.remove(sub);
        }
        return max;
    }
}