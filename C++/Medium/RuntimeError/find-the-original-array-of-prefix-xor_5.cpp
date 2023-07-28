class Solution {
public:
    vector<int> findArray(vector<int>& pref) {
        
        int n = pref.size();
        vector<int> ans(n, 0);
        for (int i = 0; i < n; ++i) {
            ans[i] = ans[i - 1] ^ pref[i];
        }
        return ans;
    }
};