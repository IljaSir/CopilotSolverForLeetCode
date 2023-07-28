class Solution {
public:
    vector<string> commonChars(vector<string>& words) {
        
        vector<string> result;
        vector<int> count(26, 0);
        for (auto c: words[0]) {
            ++count[c - 'a'];
        }
        for (int i = 1; i < words.size(); ++i) {
            vector<int> temp(26, 0);
            for (auto c: words[i]) {
                ++temp[c - 'a'];
            }
            for (int i = 0; i < 26; ++i) {
                count[i] = min(count[i], temp[i]);
            }
        }
        for (int i = 0; i < 26; ++i) {
            while (count[i]--) {
                result.push_back(string(1, i + 'a'));
            }
        }
        return result;
    }
};