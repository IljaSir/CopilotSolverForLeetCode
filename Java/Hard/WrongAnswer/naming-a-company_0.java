class Solution {
    public long distinctNames(String[] ideas) {
        
        Set<String> set = new HashSet<>();
        for (int i = 0; i < ideas.length; i++) {
            for (int j = 0; j < ideas.length; j++) {
                if (i != j) {
                    String s1 = ideas[i];
                    String s2 = ideas[j];
                    String s = (s2.charAt(0) + s1.substring(1)) + " " + (s1.charAt(0) + s2.substring(1));
                    set.add(s);
                }
            }
        }
        return set.size();
    }
}