class Solution {
public:
    int subarraysWithKDistinct(vector<int>& nums, int k) {
        
        return atMostK(nums, k) - atMostK(nums, k - 1);
    }
    int atMostK(vector<int>& nums, int k) {
        int n = nums.size(), i = 0, j = 0, res = 0;
        unordered_map<int, int> cnt;
        while (j < n) {
            if (cnt[nums[j++]]++ == 0) k--;
            while (k < 0)
                if (cnt[nums[i++]]-- == 1) k++;
            res += j - i;
        }
        return res;
    }
};