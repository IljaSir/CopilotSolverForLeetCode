class Solution {
public:
    int longestSquareStreak(vector<int>& nums) {
        
        int n = nums.size();
        sort(nums.begin(), nums.end());
        int ans = 0;
        for(int i = 0; i < n; i++)
        {
            int j = i;
            while(j < n && nums[j] == nums[i]) j++;
            if(j - i >= 2)
            {
                if(nums[i] == 0) ans = max(ans, j - i);
                else if(nums[i] % 4 == 0 && binary_search(nums.begin(), nums.end(), nums[i] / 4)) ans = max(ans, j - i);
            }
            i = j - 1;
        }
        return ans;
    }
};