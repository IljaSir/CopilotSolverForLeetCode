class Solution {
public:
    bool divideArray(vector<int>& nums) {
        
        int n = nums.size();
        sort(nums.begin(), nums.end());
        for (int i = 0; i < n; i += 2) {
            if (nums[i] != nums[i + 1]) {
                return false;
            }
        }
        return true;
    }
    bool canReorderDoubled(vector<int>& nums) {
        int n = nums.size();
        if (n % 2 != 0) {
            return false;
        }
        vector<int> pos, neg;
        for (int i = 0; i < n; ++i) {
            if (nums[i] >= 0) {
                pos.push_back(nums[i]);
            } else {
                neg.push_back(nums[i]);
            }
        }
        return divideArray(pos) && divideArray(neg);
    }
};