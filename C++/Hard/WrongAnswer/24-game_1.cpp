class Solution {
public:
    bool judgePoint24(vector<int>& cards) {
        
        vector<double> nums;
        for (int i = 0; i < 4; i++) {
            nums.push_back(cards[i]);
        }
        return solve(nums);
    }
    
    bool solve(vector<double>& nums) {
        if (nums.size() == 1) {
            return abs(nums[0] - 24) < 1e-6;
        }
        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < i; j++) {
                vector<double> tmp;
                for (int k = 0; k < nums.size(); k++) {
                    if (k != i && k != j) {
                        tmp.push_back(nums[k]);
                    }
                }
                for (int k = 0; k < 4; k++) {
                    if (k < 2 && j > i) {
                        continue;
                    }
                    if (k == 0) {
                        tmp.push_back(nums[i] + nums[j]);
                    } else if (k == 1) {
                        tmp.push_back(nums[i] * nums[j]);
                    } else if (k == 2) {
                        tmp.push_back(nums[i] - nums[j]);
                    } else if (k == 3) {
                        if (nums[j] < 1e-6) {
                            continue;
                        }
                        tmp.push_back(nums[i] / nums[j]);
                    }
                    if (solve(tmp)) {
                        return true;
                    }
                    tmp.pop_back();
                }
            }
        }
        return false;
    }
};