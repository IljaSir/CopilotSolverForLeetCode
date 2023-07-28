class Solution {
public:
    vector<int> findArray(vector<int>& pref) {
        
        int n = pref.size();
        vector<int> ans(n);
        int cur = 0;
        for (int i = 0; i < n; ++i) {
            ans[i] = cur ^ pref[i];
            cur ^= ans[i];
        }
        return ans;
    }
};