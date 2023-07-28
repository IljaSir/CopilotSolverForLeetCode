class Solution {
public:
    vector<int> secondGreaterElement(vector<int>& nums) {
        
        vector<int> result;
        for (int i = 0; i < nums.size(); i++) {
            int second = -1;
            for (int j = i + 1; j < nums.size(); j++) {
                if (nums[j] > nums[i]) {
                    if (second == -1) {
                        second = nums[j];
                    } else {
                        second = min(second, nums[j]);
                    }
                }
            }
            result.push_back(second);
        }
        return result;
    }
};