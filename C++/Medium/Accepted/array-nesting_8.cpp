class Solution {
public:
    int arrayNesting(vector<int>& nums) {
        
        int max = 0;
        for (int i = 0; i < nums.size(); i++) {
            int count = 0;
            int cur = i;
            while (nums[cur] >= 0) {
                int next = nums[cur];
                nums[cur] = -1;
                cur = next;
                count++;
            }
            if (count > max) {
                max = count;
            }
        }
        return max;
    }
};