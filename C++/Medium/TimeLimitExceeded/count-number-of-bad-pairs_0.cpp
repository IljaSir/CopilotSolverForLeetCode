class Solution {
public:
    long long countBadPairs(vector<int>& nums) {
        
        long long res = 0;
        for (int i = 0; i < nums.size(); i++) {
            for (int j = i + 1; j < nums.size(); j++) {
                if (j - i != nums[j] - nums[i]) {
                    res++;
                }
            }
        }
        return res;
    }
};