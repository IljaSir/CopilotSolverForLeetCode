class Solution {
public:
    int countEven(int num) {
        
        int count = 0;
        while (num) {
            count += num % 2;
            num /= 10;
        }
        return count;
    }
    int findNumbers(vector<int>& nums) {
        int count = 0;
        for (auto num : nums) {
            if (countEven(num) % 2 == 0) {
                count++;
            }
        }
        return count;
    }
};