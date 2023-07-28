class Solution {
    public long distinctNames(String[] ideas) {
        
        int n = ideas.length;
        HashSet<String> set = new HashSet<String>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                String str1 = ideas[i];
                String str2 = ideas[j];
                char c1 = str1.charAt(0);
                char c2 = str2.charAt(0);
                str1 = c2 + str1.substring(1);
                str2 = c1 + str2.substring(1);
                if (!set.contains(str1) && !set.contains(str2)) {
                    set.add(str1);
                    set.add(str2);
                }
            }
        }
        return set.size();
    }
}