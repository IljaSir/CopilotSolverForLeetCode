class Solution {
public:
    string sortString(string s) {
        
        vector<int> counts(26, 0);
        for (auto c : s) {
            counts[c - 'a']++;
        }
        string result;
        while (result.size() < s.size()) {
            for (int i = 0; i < 26; i++) {
                if (counts[i] > 0) {
                    result.push_back(i + 'a');
                    counts[i]--;
                }
            }
            for (int i = 25; i >= 0; i--) {
                if (counts[i] > 0) {
                    result.push_back(i + 'a');
                    counts[i]--;(i + 'a');
                    cnt[i]--;
                }
            }
        }
        return ans;
    }
};