class Solution {
public:
    vector<string> findRepeatedDnaSequences(string s) {
        
        int n = s.length();
        vector<string> ans;
        unordered_map<string, int> cnt;
        for (int i = 0; i < n - 9; i++) {
            string t = s.substr(i, 10);
            cnt[t]++;
            if (cnt[t] == 2) ans.push_back(t);
        }
        return ans;
    }
};