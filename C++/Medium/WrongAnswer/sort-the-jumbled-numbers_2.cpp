class Solution {
public:
    vector<int> sortJumbled(vector<int>& mapping, vector<int>& nums) {
        
        vector<int> result;
        for (auto num : nums) {
            int newNum = 0;
            while (num > 0) {
                newNum = newNum * 10 + mapping[num % 10];
                num /= 10;
            }
            result.push_back(newNum);
        }
        sort(result.begin(), result.end());
        return result;
    }
};