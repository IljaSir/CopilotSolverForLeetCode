class Solution {
    public List<String> commonChars(String[] words) {
        
        List<String> result = new ArrayList<String>();
        int[] count = new int[26];
        for(char c : words[0].toCharArray()){
            count[c - 'a']++;
        }
        for(int i = 1; i < words.length; i++){
            int[] temp = new int[26];
            for(char c : words[i].toCharArray()){
                temp[c - 'a']++;
            }
            for(int j = 0; j < 26; j++){
                count[j] = Math.min(count[j], temp[j]);
            }
        }
        for(int i = 0; i < 26; i++){
            while(count[i] > 0){
                result.add((char)(i + 'a') + "");
                count[i]--;
            }
        }
        return result;
    }
}