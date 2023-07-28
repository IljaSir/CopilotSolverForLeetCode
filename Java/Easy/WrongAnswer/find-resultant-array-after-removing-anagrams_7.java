class Solution {
    public List<String> removeAnagrams(String[] words) {
        
        List<String> result = new ArrayList<>();
        for(int i = 0; i < words.length; i++) {
            if(i == 0) {
                result.add(words[i]);
                continue;
            }
            boolean isAnagram = false;
            for(String s: result) {
                if(isAnagram(s, words[i])) {
                    isAnagram = true;
                    break;
                }
            }
            if(!isAnagram)
                result.add(words[i]);
        }
        return result;
    }
    
    public boolean isAnagram(String s1, String s2) {
        if(s1.length() != s2.length())
            return false;
        int[] count = new int[26];
        for(int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }
        for(int i = 0; i < 26; i++) {
            if(count[i] != 0)
                return false;
        }
        return true;
    }
}