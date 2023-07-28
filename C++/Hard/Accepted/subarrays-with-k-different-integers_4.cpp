class Solution {
public:
    int subarraysWithKDistinct(vector<int>& nums, int k) {
        
        return atMostK(nums, k) - atMostK(nums, k-1);
    }
    
    int atMostK(vector<int>& nums, int k) {
        int ans = 0;
        unordered_map<int, int> count;
        for (int i = 0, j = 0; i < nums.size(); i++) {
            if (count[nums[i]]++ == 0) k--;
            while (k < 0) {
                if (--count[nums[j++]] == 0) k++;
            }
            ans += i - j + 1;
        }
        return ans;
    }
};