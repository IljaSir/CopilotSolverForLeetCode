class Solution {
public:
    int vowelStrings(vector<string>& words, int left, int right) {
        
        int ret = 0;
        for (int i = left; i <= right; i++) {
            for (auto c : words[i]) {
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                    ret++;
                }
            }
        }
        return ret;
    }
};