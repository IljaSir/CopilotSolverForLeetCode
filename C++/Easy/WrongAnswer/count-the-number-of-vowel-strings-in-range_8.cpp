class Solution {
public:
    int vowelStrings(vector<string>& words, int left, int right) {
        
        int count = 0;
        for (int i = left; i <= right; ++i) {
            int len = words[i].length();
            if (len < 2) {
                continue;
            }
            if (words[i][0] == 'a' || words[i][0] == 'e' || words[i][0] == 'i' || words[i][0] == 'o' || words[i][0] == 'u') {
                if (words[i][len - 1] == 'a' || words[i][len - 1] == 'e' || words[i][len - 1] == 'i' || words[i][len - 1] == 'o' || words[i][len - 1] == 'u') {
                    ++count;
                }
            }
        }
        return count;
    }
};