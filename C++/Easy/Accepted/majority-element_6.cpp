class Solution {
public:
    int majorityElement(vector<int>& nums) {
        
        int cnt = 0;
        int major = nums[0];
        for (int i = 0; i < nums.size(); ++i) {
            if (cnt == 0) {
                major = nums[i];
                cnt++;
            } else if (major == nums[i]) {
                cnt++;
            } else {
                cnt--;
            }
        }
        return major;
    }
};