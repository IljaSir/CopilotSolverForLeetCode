class Solution {
public:
    int thirdMax(vector<int>& nums) {
        
        int n = nums.size();
        int max1 = INT_MIN;
        int max2 = INT_MIN;
        int max3 = INT_MIN;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == max1 || nums[i] == max2 || nums[i] == max3) {
                continue;
            }
            if (nums[i] > max1) {
                max3 = max2;
                max2 = max1;
                max1 = nums[i];
                cnt++;
            } else if (nums[i] > max2) {
                max3 = max2;
                max2 = nums[i];
                cnt++;
            } else if (nums[i] > max3) {
                max3 = nums[i];
                cnt++;
            }
        }
        if (cnt < 3) {
            return max1;
        }
        return max3;
    }
};