class Solution {
public:
    void sortColors(vector<int>& nums) {
        
        int count[3] = {0};
        for (auto i : nums) {
            count[i]++;
        }
        int j = 0;
        for (int i = 0; i < 3; i++) {
            while (count[i]-- > 0) {
                nums[j++] = i;
            }
        }
    }
};