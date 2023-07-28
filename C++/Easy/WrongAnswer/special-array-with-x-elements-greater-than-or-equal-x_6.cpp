class Solution {
public:
    int specialArray(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> count(n + 1, 0);
        for (int i = 0; i < n; ++i) {
            count[min(nums[i], n)]++;
        }
        for (int i = n - 1; i >= 0; --i) {
            count[i] += count[i + 1];
            if (count[i] == i) {
                return i;
            }
        }
        return -1;
    }
};