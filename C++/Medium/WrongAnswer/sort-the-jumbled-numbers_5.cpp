class Solution {
public:
    vector<int> sortJumbled(vector<int>& mapping, vector<int>& nums) {
        
        vector<int> result;
        for (int i = 0; i < nums.size(); i++) {
            int j = 0;
            int temp = 0;
            while (nums[i] > 0) {
                temp += mapping[nums[i] % 10] * pow(10, j);
                nums[i] /= 10;
                j++;
            }
            result.push_back(temp);
        }
        sort(result.begin(), result.end());
        return result;
    }
};