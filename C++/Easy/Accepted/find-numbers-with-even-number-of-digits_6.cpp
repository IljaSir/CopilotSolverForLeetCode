class Solution {
public:
    int findNumbers(vector<int>& nums) {
        
        int count = 0;
        for (int i = 0; i < nums.size(); i++) {
            int n = nums[i];
            int d = 0;
            while (n > 0) {
                n /= 10;
                d++;
            }
            if (d % 2 == 0) {
                count++;
            }
        }
        return count;
    }
};