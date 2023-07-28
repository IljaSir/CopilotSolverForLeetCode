class Solution {
public:
    int averageValue(vector<int>& nums) {
        
        int sum = 0;
        int count = 0;
        for (auto num : nums) {
            if (num % 2 == 0 && num % 3 == 0) {
                sum += num;
                count++;
            }
        }
        return sum / count;
    }
};