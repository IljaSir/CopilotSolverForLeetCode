class Solution {
    public List<String> removeAnagrams(String[] words) {
        
        List<String> result = new ArrayList<>();
        int wordLen = words.length;
        for(int i = 0; i < wordLen; i++){
            String word = words[i];
            if(word == null){
                continue;
            }
            int len = word.length();
            boolean found = false;
            for(int j = i + 1; j < wordLen; j++){
                if(words[j] == null){
                    continue;
                }
                if(words[j].length() != len){
                    continue;
                }
                if(isAnagram(word, words[j])){
                    words[j] = null;
                    found = true;
                }
            }
            if(!found){
                result.add(word);
            }
        }
        return result;
    }
    
    public boolean isAnagram(String word1, String word2){
        int[] charCount = new int[26];
        for(char c : word1.toCharArray()){
            charCount[c - 'a']++;
        }
        for(char c : word2.toCharArray()){
            charCount[c - 'a']--;
        }
        for(int count : charCount){
            if(count != 0){
                return false;
            }
        }
        return true;
    }
}