class Solution {
public:
    int subarraysWithKDistinct(vector<int>& nums, int k) {
        
        int n = nums.size();
        int i = 0, j = 0;
        int res = 0;
        unordered_map<int, int> count;
        while (j < n) {
            while (j < n && count.size() < k) {
                count[nums[j]]++;
                if (count[nums[j]] == 1) {
                    if (count.size() == k) {
                        res += (n - j);
                    }
                }
                j++;
            }
            while (i < j && count.size() == k) {
                count[nums[i]]--;
                if (count[nums[i]] == 0) {
                    count.erase(nums[i]);
                }
                if (count.size() < k) {
                    res += (j - i - 1);
                }
                i++;
            }
        }
        return res;
    }
};