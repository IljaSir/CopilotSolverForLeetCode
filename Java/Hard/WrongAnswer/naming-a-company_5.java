class Solution {
    public long distinctNames(String[] ideas) {
        
        Set<String> set = new HashSet<>();
        for(int i = 0; i < ideas.length; i++){
            for(int j = 0; j < ideas.length; j++){
                if(i == j) continue;
                String s1 = ideas[i].substring(0, 1) + ideas[j].substring(1);
                String s2 = ideas[j].substring(0, 1) + ideas[i].substring(1);
                if(!set.contains(s1) && !set.contains(s2)) set.add(s1 + " " + s2);
            }
        }
        return set.size();
    }
}