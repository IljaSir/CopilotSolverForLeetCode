class Solution {
public:
    int minPatches(vector<int>& nums, int n) {
        
        int i = 0;
        long long sum = 0;
        int count = 0;
        while (sum < n) {
            if (i < nums.size() && nums[i] <= sum + 1) {
                sum += nums[i];
                i++;
            } else {
                sum += sum + 1;
                count++;
            }
        }
        return count;
    }
};