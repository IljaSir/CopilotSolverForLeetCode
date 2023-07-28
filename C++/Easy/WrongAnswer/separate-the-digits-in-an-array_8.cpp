class Solution {
public:
    vector<int> separateDigits(vector<int>& nums) {
        
        vector<int> out;
        for(int i = 0; i < nums.size(); i++) {
            int num = nums[i];
            while(num > 0) {
                int digit = num % 10;
                num /= 10;
                out.push_back(digit);
            }
        }
        return out;
    }
};