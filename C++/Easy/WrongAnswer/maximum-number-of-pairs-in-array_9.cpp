class Solution {
public:
    vector<int> numberOfPairs(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> count(101);
        for (auto &i : nums) {
            count[i]++;
        }
        int total = 0;
        int left = 0;
        for (int i = 0; i <= 100; i++) {
            if (count[i] > 1) {
                total += count[i] / 2;
                if (count[i] % 2 == 1) {
                    left++;
                }
            }
        }
        return {total, left};
    }
};