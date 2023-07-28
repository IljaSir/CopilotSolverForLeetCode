class Solution {
public:
    int findMaxK(vector<int>& nums) {
        
        int n = nums.size(), maxK = -1;
        unordered_map<int, int> m;
        for (int i = 0; i < n; i++) {
            m[nums[i]]++;
            if (nums[i] > 0)
                maxK = max(maxK, nums[i]);
        }
        for (int i = 1; i <= maxK; i++) {
            if (m.count(-i))
                return i;
        }
        return -1;
    }
    int largestMagicalString(int n) {
        vector<int> nums(1, 1);
        int i = 0, j = 0;
        while (nums.size() < n) {
            nums.push_back(nums.back() ^ 3);
            for (int k = 0; k < nums[j]; k++) {
                nums.push_back(nums.back() ^ 3);
                if (nums.size() == n)
                    break;
            }
            i++;
            j++;
        }
        return findMaxK(nums);
    }
};