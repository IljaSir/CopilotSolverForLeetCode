class Solution {
public:
    vector<int> numberOfPairs(vector<int>& nums) {
        
        int count = 0;
        int left = 0;
        vector<int> map(101, 0);
        for (int i = 0; i < nums.size(); ++i) {
            map[nums[i]]++;
        }
        for (int i = 0; i < 101; ++i) {
            if (map[i] > 1) {
                count += map[i] / 2;
                left += map[i] % 2;
            }
            if (map[i] == 1) {
                left++;
            }
        }
        return {count, left};
    }
};