class Solution {
public:
    int specialArray(vector<int>& nums) {
        
        int size = nums.size();
        for (int i = 0; i <= size; i++) {
            int count = 0;
            for (int j = 0; j < size; j++) {
                if (nums[j] >= i) {
                    count++;
                }
            }
            if (count == i) {
                return i;
            }
        }
        return -1;
    }
};