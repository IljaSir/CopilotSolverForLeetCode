class Solution {
public:
    bool canBeIncreasing(vector<int>& nums) {
        
        int n = nums.size();
        for (int i = 0; i < n; i++) {
            bool ok = true;
            for (int j = 1; j < n; j++) {
                if (j == i) continue;
                if (j == i + 1 && nums[j] <= nums[i]) {
                    ok = false;
                    break;
                }
                if (nums[j] <= nums[j - 1]) {
                    ok = false;
                    break;
                }
            }
            if (ok) return true;
        }
        return false;
    }
};