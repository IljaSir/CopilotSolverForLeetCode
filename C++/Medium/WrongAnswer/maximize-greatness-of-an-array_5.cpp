class Solution {
public:
    int maximizeGreatness(vector<int>& nums) {
        
        sort(nums.begin(), nums.end());
        int n = nums.size();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] > nums[n - i - 1]) {
                count++;
            }
        }
        return count;
    }
};