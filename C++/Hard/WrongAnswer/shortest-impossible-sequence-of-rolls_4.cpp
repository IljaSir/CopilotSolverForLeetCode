class Solution {
public:
    int shortestSequence(vector<int>& rolls, int k) {
        
        int n = rolls.size();
        vector<int> cnt(k + 1, 0);
        int res = n + 1;
        int l = 0;
        for (int r = 0; r < n; ++r) {
            cnt[rolls[r]]++;
            while (cnt[rolls[r]] > 1) {
                cnt[rolls[l]]--;
                l++;
            }
            if (r - l + 1 == k) {
                res = min(res, r - l + 1);
            }
        }
        return res == n + 1 ? -1 : res;
    }
};