class Solution {
public:
    int countEven(int num) {
        
        int count = 0;
        while (num) {
            if ((num % 10) % 2 == 0) {
                count++;
            }
            num /= 10;
        }
        return count;
    }
    int findNumbers(vector<int>& nums) {
        int count = 0;
        for (int num : nums) {
            if (countEven(num) % 2 == 0) {
                count++;
            }
        }
        return count;
    }
};