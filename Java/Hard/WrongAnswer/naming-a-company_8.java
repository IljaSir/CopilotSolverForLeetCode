class Solution {
    public long distinctNames(String[] ideas) {
        
        Set<String> set = new HashSet<>();
        for (String idea : ideas) {
            for (String other : ideas) {
                if (idea.equals(other)) {
                    continue;
                }
                String newName = other.substring(0, 1) + idea.substring(1) + " " + idea.substring(0, 1) + other.substring(1);
                set.add(newName);
            }
        }
        return set.size();
    }
}