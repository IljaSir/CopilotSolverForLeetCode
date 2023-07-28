class Solution {
public:
    int findNumbers(vector<int>& nums) {
        
        int c = 0;
        for (int i = 0; i < nums.size(); i++) {
            int d = 0;
            while (nums[i] > 0) {
                d++;
                nums[i] /= 10;
            }
            if (d % 2 == 0) c++;
        }
        return c;
    }
};