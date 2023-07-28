class Solution {
    public List<String> removeAnagrams(String[] words) {
        
        List<String> result = new ArrayList<String>();
        boolean[] isAnagram = new boolean[words.length];
        for (int i = 0; i < words.length; i++) {
            if (!isAnagram[i]) {
                result.add(words[i]);
                for (int j = i + 1; j < words.length; j++) {
                    if (!isAnagram[j]) {
                        if (isAnagram(words[i], words[j])) {
                            isAnagram[j] = true;
                        }
                    }
                }
            }
        }
        return result;
    }
    public boolean isAnagram(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }
        int[] alphabet = new int[26];
        for (int i = 0; i < a.length(); i++) {
            alphabet[a.charAt(i) - 'a']++;
        }
        for (int i = 0; i < b.length(); i++) {
            alphabet[b.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (alphabet[i] != 0) {
                return false;
            }
        }
        return true;
    }
}