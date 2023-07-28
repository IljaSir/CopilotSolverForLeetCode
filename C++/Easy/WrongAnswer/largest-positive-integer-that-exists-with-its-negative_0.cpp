class Solution {
public:
    int findMaxK(vector<int>& nums) {
        
        int max = 0;
        for (int i = 0; i < nums.size(); i++)
        {
            if (nums[i] > 0 && nums[i] > max)
            {
                max = nums[i];
            }
        }
        return max;
    }
    int largestNumber(vector<int>& nums) {
        int maxK = findMaxK(nums);
        for (int k = maxK; k > 0; k--)
        {
            bool found = false;
            for (int i = 0; i < nums.size(); i++)
            {
                if (nums[i] == k)
                {
                    found = true;
                    break;
                }
            }
            if (found)
            {
                for (int i = 0; i < nums.size(); i++)
                {
                    if (nums[i] == -k)
                    {
                        return k;
                    }
                }
            }
        }
        return -1;
    }
};