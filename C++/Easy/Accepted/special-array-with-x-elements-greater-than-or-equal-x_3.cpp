class Solution {
public:
    int specialArray(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> count(n+1, 0);
        for (int i = 0; i < n; i++) {
            if (nums[i] >= n) {
                count[n]++;
            } else {
                count[nums[i]]++;
            }
        }
        int sum = 0;
        for (int i = n; i >= 0; i--) {
            sum += count[i];
            if (sum == i) {
                return i;
            }
        }
        return -1;
    }
};