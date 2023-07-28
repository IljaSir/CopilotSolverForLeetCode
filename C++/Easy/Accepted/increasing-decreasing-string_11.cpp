class Solution {
public:
    string sortString(string s) {
        
        int n = s.size();
        string ans;
        vector<int> cnt(26, 0);
        for (char c : s) {
            cnt[c - 'a']++;
        }
        while (ans.size() < n) {
            for (int i = 0; i < 26; i++) {
                if (cnt[i]) {
                    ans.push_back(i + 'a');
                    cnt[i]--;
                }
            }
            for (int i = 25; i >= 0; i--) {
                if (cnt[i]) {
                    ans.push_back(i + 'a');
                    cnt[i]--;
                }
            }
        }
        return ans;
    }
};