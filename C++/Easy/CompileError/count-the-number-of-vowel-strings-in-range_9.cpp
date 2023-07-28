class Solution {
public:
    int vowelStrings(vector<string>& words, int left, int right) {
        
        int count = 0;
        for(int i = left; i <= right; i++) {
            int len = words[i].length();
            if(len > 1) {
                if(isVowel(words[i][0]) && isVowel(words[i][len-1])) {
                    count++;
                }
            }
        }
        return count;
    }
};