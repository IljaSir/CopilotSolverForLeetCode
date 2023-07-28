class Solution {
public:
    int sumOfUnique(vector<int>& nums) {
        
        int sum = 0;
        for (int i = 0; i < nums.size(); i++) {
            bool unique = true;
            for (int j = 0; j < nums.size(); j++) {
                if (i != j && nums[i] == nums[j]) {
                    unique = false;
                    break;
                }
            }
            if (unique) {
                sum += nums[i];
            }
        }
        return sum;
    }
};