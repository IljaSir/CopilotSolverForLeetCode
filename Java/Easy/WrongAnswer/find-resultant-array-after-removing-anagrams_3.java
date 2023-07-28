class Solution {
    public List<String> removeAnagrams(String[] words) {
        
        List<String> result = new ArrayList<>();
        for (String word : words) {
            if (result.isEmpty()) {
                result.add(word);
                continue;
            }
            boolean isAnagram = false;
            for (int i = 0; i < result.size(); i++) {
                String current = result.get(i);
                if (current.length() == word.length() && isAnagram(current, word)) {
                    isAnagram = true;
                    result.remove(i);
                    break;
                }
            }
            if (!isAnagram) {
                result.add(word);
            }
        }
        return result;
    }
    
    private boolean isAnagram(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
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