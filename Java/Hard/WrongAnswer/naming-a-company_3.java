class Solution {
    public long distinctNames(String[] ideas) {
        
        Set<String> set = new HashSet<>();
        for (int i = 0; i < ideas.length; i++) {
            for (int j = i + 1; j < ideas.length; j++) {
                String name = ideas[i].charAt(0) + ideas[j].substring(1) + " " + ideas[j].charAt(0) + ideas[i].substring(1);
                set.add(name);
            }
        }
        return set.size();
    }
}