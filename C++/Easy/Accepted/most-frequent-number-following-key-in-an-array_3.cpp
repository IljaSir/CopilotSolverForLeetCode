class Solution {
public:
    int mostFrequent(vector<int>& nums, int key) {
        
        int ans = -1, max = 0;
        for (int i = 0; i < nums.size() - 1; i++) {
            if (nums[i] == key) {
                int target = nums[i + 1];
                int count = 0;
                for (int j = i; j < nums.size() - 1; j++) {
                    if (nums[j] == key && nums[j + 1] == target) {
                        count++;
                    }
                }
                if (count > max) {
                    ans = target;
                    max = count;
                }
            }
        }
        return ans;
    }
};