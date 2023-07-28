class Solution {
public:
    vector<int> replaceNonCoprimes(vector<int>& nums) {
        
        vector<int> result;
        for (int i = 0; i < nums.size(); i++) {
            int j = i + 1;
            for (; j < nums.size(); j++) {
                if (gcd(nums[i], nums[j]) == 1) {
                    break;
                }
            }
            if (j == nums.size()) {
                result.push_back(nums[i]);
            } else {
                int lcm = nums[i] * nums[j] / gcd(nums[i], nums[j]);
                result.push_back(lcm);
                i = j;
            }
        }
        return result;
    }
};