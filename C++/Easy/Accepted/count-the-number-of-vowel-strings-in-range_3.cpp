class Solution {
public:
    int vowelStrings(vector<string>& words, int left, int right) {
        
        int count = 0;
        for(int i = left; i <= right; i++) {
            string word = words[i];
            if(word[0] == 'a' || word[0] == 'e' || word[0] == 'i' || word[0] == 'o' || word[0] == 'u') {
                int len = word.length();
                if(word[len-1] == 'a' || word[len-1] == 'e' || word[len-1] == 'i' || word[len-1] == 'o' || word[len-1] == 'u') {
                    count++;
                }
            }
        }
        return count;
    }
};