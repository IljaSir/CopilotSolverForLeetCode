class Solution {
public:
    bool divideArray(vector<int>& nums) {
        
        if (nums.size() % 2 == 1) {
            return false;
        }
        sort(nums.begin(), nums.end());
        for (int i = 0; i < nums.size(); i += 2) {
            if (nums[i] != nums[i + 1]) {
                return false;
            }
        }
        return true;
    }
    bool canReorderDoubled(vector<int>& nums) {
        vector<int> pos;
        vector<int> neg;
        for (int i = 0; i < nums.size(); ++i) {
            if (nums[i] >= 0) {
                pos.push_back(nums[i]);
            } else {
                neg.push_back(nums[i]);
            }
        }
        return divideArray(pos) && divideArray(neg);
    }
};