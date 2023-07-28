class Solution {
public:
    vector<int> numberOfPairs(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> cnt(101);
        for (int i = 0; i < n; i++) {
            cnt[nums[i]]++;
        }
        int res = 0;
        for (int i = 0; i <= 100; i++) {
            res += cnt[i] / 2;
            cnt[i] %= 2;
        }
        int rem = 0;
        for (int i = 0; i <= 100; i++) {
            rem += cnt[i];
        }
        return {res, rem};
    }
};