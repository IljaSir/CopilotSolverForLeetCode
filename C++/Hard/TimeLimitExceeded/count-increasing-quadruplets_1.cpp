class Solution {
public:
    long long countQuadruplets(vector<int>& nums) {
        
        long long res = 0;
        for (int i = 0; i < nums.size() - 3; i++) {
            for (int j = i + 1; j < nums.size() - 2; j++) {
                for (int k = j + 1; k < nums.size() - 1; k++) {
                    for (int l = k + 1; l < nums.size(); l++) {
                        if (nums[i] < nums[k] && nums[k] < nums[j] && nums[j] < nums[l]) {
                            res++;
                        }
                    }
                }
            }
        }
        return res;
    }
};