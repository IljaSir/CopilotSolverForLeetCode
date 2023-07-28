class Solution {
public:
    int countQuadruplets(vector<int>& nums) {
        
        int N = nums.size();
        int res = 0;
        for (int i = 0; i < N - 3; i++) {
            for (int j = i + 1; j < N - 2; j++) {
                for (int k = j + 1; k < N - 1; k++) {
                    for (int l = k + 1; l < N; l++) {
                        if (nums[i] + nums[j] + nums[k] == nums[l]) {
                            res++;
                        }
                    }
                }
            }
        }
        return res;
    }
};