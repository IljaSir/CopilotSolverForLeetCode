class Solution {
public:
    int findMiddleIndex(vector<int>& nums) {
        
        int n = nums.size();
        if (n == 1) return 0;
        if (n == 2) return -1;
        vector<int> left(n, 0);
        vector<int> right(n, 0);
        for (int i = 1; i < n; ++i)
            left[i] = left[i-1] + nums[i-1];
        for (int i = n-2; i >= 0; --i)
            right[i] = right[i+1] + nums[i+1];
        for (int i = 0; i < n; ++i)
            if (left[i] == right[i])
                return i;
        return -1;
    }
};