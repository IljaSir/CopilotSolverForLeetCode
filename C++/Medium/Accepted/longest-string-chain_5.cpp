class Solution {
public:
    int longestStrChain(vector<string>& words) {
        
        sort(words.begin(), words.end(), [](string& a, string& b) {
            return a.size() < b.size();
        });
        unordered_map<string, int> mp;
        int res = 0;
        for (auto& word : words) {
            for (int i = 0; i < word.size(); ++i) {
                string prev = word.substr(0, i) + word.substr(i + 1);
                mp[word] = max(mp[word], mp[prev] + 1);
            }
            res = max(res, mp[word]);
        }
        return res;
    }
};