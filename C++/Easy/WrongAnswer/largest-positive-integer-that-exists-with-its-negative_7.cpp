class Solution {
public:
    int findMaxK(vector<int>& nums) {
        
        int max = 0;
        for(int i=0; i<nums.size(); i++)
        {
            if(nums[i] < 0)
            {
                if(nums[i] > max)
                    max = nums[i];
            }
            else
            {
                if(-nums[i] > max)
                    max = -nums[i];
            }
        }
        return max;
    }
    int findKthPositive(vector<int>& arr, int k) {
        int max = findMaxK(arr);
        int count = 0;
        int i = 0;
        while(count < k)
        {
            i++;
            if(i > max)
                return k - count;
            bool found = false;
            for(int j=0; j<arr.size(); j++)
            {
                if(arr[j] == i)
                {
                    found = true;
                    break;
                }
            }
            if(!found)
                count++;
        }
        return i;
    }
};