class Solution {
public:
    vector<int> sortJumbled(vector<int>& mapping, vector<int>& nums) {
        
        vector<int> result;
        for (int i = 0; i < nums.size(); i++) {
            int num = nums[i];
            int sum = 0;
            int mul = 1;
            while (num > 0) {
                int d = num % 10;
                sum += mul * mapping[d];
                mul *= 10;
                num /= 10;
            }
            result.push_back(sum);
        }
        sort(result.begin(), result.end());
        return result;
    }
};