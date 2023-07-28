class Solution {
    public long distinctNames(String[] ideas) {
        
        Set<String> set = new HashSet<String>();
        for(int i=0;i<ideas.length;i++){
            for(int j=i+1;j<ideas.length;j++){
                String s1 = ideas[i];
                String s2 = ideas[j];
                String s3 = s2.charAt(0)+s1.substring(1);
                String s4 = s1.charAt(0)+s2.substring(1);
                if(!set.contains(s3) && !set.contains(s4)){
                    set.add(s3);
                    set.add(s4);
                }
            }
        }
        return set.size();
    }
}