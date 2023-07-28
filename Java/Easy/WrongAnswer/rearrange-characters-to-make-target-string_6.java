class Solution {
    public int rearrangeCharacters(String s, String target) {
        
        int[] freq = new int[26];
        for(char c : s.toCharArray()){
            freq[c - 'a']++;
        }
        for(char c : target.toCharArray()){
            freq[c - 'a']--;
        }
        for(int i : freq){
            if(i < 0){
                return 0;
            }
        }
        int max = 0;
        for(char c : target.toCharArray()){
            max = Math.max(max, freq[c - 'a']);
        }
        return max;
    }
}