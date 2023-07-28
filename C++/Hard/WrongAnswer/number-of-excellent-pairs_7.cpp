class Solution {
public:
    long long countExcellentPairs(vector<int>& nums, int k) {
        
        long long result = 0;
        vector<int> setBits(32, 0);
        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < 32; j++) {
                if ((nums[i] >> j) & 1) {
                    setBits[j]++;
                }
            }
        }
        for (int i = 0; i < nums.size(); i++) {
            int cnt = 0;
            for (int j = 0; j < 32; j++) {
                if ((nums[i] >> j) & 1) {
                    cnt += setBits[j];
                } else {
                    cnt += (nums.size() - setBits[j]);
                }
            }
            if (cnt >= k) {
                result++;
            }
        }
        return result;
    }
};