class Solution {
    public int[] sumPrefixScores(String[] words) {
        
        int[] answer = new int[words.length];
        int[] prefix = new int[26];
        for (int i = 0; i < words.length; i++) {
            int[] temp = new int[26];
            for (int j = 0; j < words[i].length(); j++) {
                temp[words[i].charAt(j) - 'a']++;
                prefix[words[i].charAt(j) - 'a']++;
                answer[i] += prefix[words[i].charAt(j) - 'a'];
            }
            prefix = temp;
        }
        return answer;
    }
}