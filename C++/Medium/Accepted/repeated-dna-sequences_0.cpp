class Solution {
public:
    vector<string> findRepeatedDnaSequences(string s) {
        
        unordered_map<string, int> cnt;
        for (int i = 0; i + 10 <= s.length(); ++i) {
            ++cnt[s.substr(i, 10)];
        }
        vector<string> ans;
        for (auto& [k, v] : cnt) {
            if (v > 1) ans.push_back(k);
        }
        return ans;
    }
};