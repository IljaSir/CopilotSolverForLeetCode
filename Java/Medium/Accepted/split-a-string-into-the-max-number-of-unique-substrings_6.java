class Solution {
    public int maxUniqueSplit(String s) {
        
        return maxUniqueSplit(s, 0, new HashSet<>());
    }
    
    private int maxUniqueSplit(String s, int index, Set<String> set) {
        if (index == s.length()) {
            return set.size();
        }
        
        int max = 0;
        for (int i = index; i < s.length(); i++) {
            String sub = s.substring(index, i + 1);
            if (set.add(sub)) {
                max = Math.max(max, maxUniqueSplit(s, i + 1, set));
                set.remove(sub);
            }
        }
        return max;
    }
}