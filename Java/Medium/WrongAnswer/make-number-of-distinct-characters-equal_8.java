class Solution {
    public boolean isItPossible(String word1, String word2) {
        
    	if(word1.length() != word2.length()) return false;
    	int[] count1 = new int[26];
    	int[] count2 = new int[26];
    	for(int i = 0; i < word1.length(); i++) {
    		count1[word1.charAt(i) - 'a']++;
    		count2[word2.charAt(i) - 'a']++;
    	}
    	int diff1 = 0;
    	int diff2 = 0;
    	for(int i = 0; i < 26; i++) {
    		if(count1[i] > 0) diff1++;
    		if(count2[i] > 0) diff2++;
    	}
    	if(diff1 != diff2) return false;
    	for(int i = 0; i < 26; i++) {
    		if(count1[i] > 0 && count2[i] == 0) return false;
    	}
    	return true;
    }
}