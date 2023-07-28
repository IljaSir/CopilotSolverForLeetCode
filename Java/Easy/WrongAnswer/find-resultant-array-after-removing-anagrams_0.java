class Solution {
    public List<String> removeAnagrams(String[] words) {
        
        List<String> res = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            boolean isAnagram = false;
            for (int j = 0; j < res.size(); j++) {
                if (isAnagram(res.get(j), words[i])) {
                    isAnagram = true;
                    break;
                }
            }
            if (!isAnagram) {
                res.add(words[i]);
            }
        }
        return res;
    }

    private boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int[] count = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                return false;
            }
        }
        return true;
    }
}