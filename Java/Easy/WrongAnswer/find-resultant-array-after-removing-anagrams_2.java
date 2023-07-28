class Solution {
    public List<String> removeAnagrams(String[] words) {
        
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            boolean isAnagram = false;
            for (int j = 0; j < result.size(); j++) {
                if (isAnagram(result.get(j), words[i])) {
                    isAnagram = true;
                    break;
                }
            }
            if (!isAnagram) {
                result.add(words[i]);
            }
        }
        return result;
    }
    
    private boolean isAnagram(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }
        int[] count = new int[26];
        for (int i = 0; i < a.length(); i++) {
            count[a.charAt(i) - 'a']++;
            count[b.charAt(i) - 'a']--;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                return false;
            }
        }
        return true;
    }
}