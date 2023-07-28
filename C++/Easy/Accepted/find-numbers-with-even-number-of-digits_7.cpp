class Solution {
public:
    int findNumbers(vector<int>& nums) {
        
        int count = 0;
        for (auto n: nums) {
            int digits = 0;
            while (n > 0) {
                n /= 10;
                digits++;
            }
            if (digits % 2 == 0) {
                count++;
            }
        }
        return count;
    }
};