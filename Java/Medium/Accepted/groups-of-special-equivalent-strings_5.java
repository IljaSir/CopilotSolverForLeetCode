class Solution {
    public int numSpecialEquivGroups(String[] words) {
        
        Set<String> set = new HashSet<>();
        for(String word : words){
            int[] odd = new int[26];
            int[] even = new int[26];
            for(int i=0; i<word.length(); i++){
                char c = word.charAt(i);
                if(i % 2 == 0){
                    even[c - 'a']++;
                }else{
                    odd[c - 'a']++;
                }
            }
            set.add(Arrays.toString(odd) + Arrays.toString(even));
        }
        return set.size();
    }
}