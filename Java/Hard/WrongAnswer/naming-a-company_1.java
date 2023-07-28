class Solution {
    public long distinctNames(String[] ideas) {
        
        int n = ideas.length;
        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                String s1 = ideas[i];
                String s2 = ideas[j];
                if (s1.charAt(0) != s2.charAt(0)) {
                    String newS1 = s2.charAt(0) + s1.substring(1);
                    String newS2 = s1.charAt(0) + s2.substring(1);
                    if (!set.contains(newS1) && !set.contains(newS2)) {
                        set.add(newS1);
                        set.add(newS2);
                    }
                }
            }
        }
        return set.size();
    }
}