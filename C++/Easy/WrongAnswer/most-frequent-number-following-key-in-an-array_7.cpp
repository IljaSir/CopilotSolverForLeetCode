class Solution {
public:
    int mostFrequent(vector<int>& nums, int key) {
        
        int count = 0;
        int max_count = 0;
        int max_count_num = 0;
        for(int i = 0; i < nums.size() - 1; i++) {
            if(nums[i] == key) {
                if(nums[i + 1] == nums[i]) {
                    count++;
                } else {
                    if(count > max_count) {
                        max_count = count;
                        max_count_num = nums[i];
                    }
                    count = 0;
                }
            }
        }
        return max_count_num;
    }
};