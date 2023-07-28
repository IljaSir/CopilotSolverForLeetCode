class Solution {
public:
    vector<int> singleNumber(vector<int>& nums) {
        
        int n = nums.size();
        int a = 0;
        for(int i = 0; i < n; i++)
            a ^= nums[i];
        int b = a & (-a);
        int c = 0;
        int d = 0;
        for(int i = 0; i < n; i++)
            if(nums[i] & b)
                c ^= nums[i];
            else
                d ^= nums[i];
        return {c, d};
    }
};