class Solution {
public:
    vector<int> numberOfPairs(vector<int>& nums) {
        
        vector<int> res(2, 0);
        int n = nums.size();
        if (n < 2) return res;
        
        vector<int> cnt(101, 0);
        for (int i = 0; i < n; ++i) {
            cnt[nums[i]]++;
        }
        
        for (int i = 0; i < 101; ++i) {
            if (cnt[i] > 1) {
                res[0] += cnt[i] / 2;
                res[1] += cnt[i] % 2;
            }
        }
        
        return res;
    }
};