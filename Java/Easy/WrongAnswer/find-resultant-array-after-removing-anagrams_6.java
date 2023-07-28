class Solution {
    public List<String> removeAnagrams(String[] words) {
        
        List<String> res = new ArrayList<String>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            boolean isAnagram = false;
            for (int j = 0; j < res.size(); j++) {
                if (isAnagram(word, res.get(j))) {
                    isAnagram = true;
                    break;
                }
            }
            if (!isAnagram) {
                res.add(word);
            }
        }
        return res;
    }
    
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                return false;
            }
        }
        return true;
    }
}