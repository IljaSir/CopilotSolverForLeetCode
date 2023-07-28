class Solution {
    public int maxUniqueSplit(String s) {
        
        return split(s, new HashSet<String>());
    }
    
    private int split(String s, Set<String> set) {
        if (s.length() == 0) {
            return 0;
        }
        
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            String sub = s.substring(0, i + 1);
            if (!set.contains(sub)) {
                set.add(sub);
                max = Math.max(max, 1 + split(s.substring(i + 1), set));
                set.remove(sub);
            }
        }
        return max;
    }
}