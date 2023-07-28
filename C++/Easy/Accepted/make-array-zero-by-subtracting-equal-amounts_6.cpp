class Solution {
public:
    int minimumOperations(vector<int>& nums) {
        
        sort(nums.begin(), nums.end());
        int i = 0;
        for (int j = 0; j < nums.size(); j++) {
            if (nums[j] > 0) {
                nums[i++] = nums[j];
            }
        }
        nums.resize(i);
        int count = 0;
        while (nums.size() > 0) {
            int x = nums[0];
            for (int i = 0; i < nums.size(); i++) {
                nums[i] -= x;
            }
            count++;
            i = 0;
            for (int j = 0; j < nums.size(); j++) {
                if (nums[j] > 0) {
                    nums[i++] = nums[j];
                }
            }
            nums.resize(i);
        }
        return count;
    }
};