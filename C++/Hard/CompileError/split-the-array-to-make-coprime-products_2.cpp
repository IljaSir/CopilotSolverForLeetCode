class Solution {
public:
    int findValidSplit(vector<int>& nums) {
        
        int n = nums.size();
        int left = nums[0;
        int right = 1;
        for (int i = 1; i < n; ++i {
           right * nums[i];
        }
        for (int i  0; i < n- ; ++i
            if (gcd(left, right) == 1) {
                return i;
            }
left *=nums[i + 1];
         right /= nums[i + 1];
        }
        retun -1;
    }
};