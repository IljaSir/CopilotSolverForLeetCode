class Solution {
public:
    int findLUSlength(vector<string>& strs) {
        
        unordered_map<string, int> mp;
        for (auto s : strs) mp[s]++;
        int res = -1;
        for (auto& [s, cnt] : mp) {
            if (cnt == 1) {
                bool isSub = false;
                for (auto& [t, cnt2] : mp) {
                    if (s.size() < t.size() && isSubsequence(s, t)) {
                        isSub = true;
                        break;
                    }
                }
                if (!isSub) res = max(res, (int)s.size());
            }
        }
        return res;
    }
};