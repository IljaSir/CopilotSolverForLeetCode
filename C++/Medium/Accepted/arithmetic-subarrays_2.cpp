class Solution {
public:
    vector<bool> checkArithmeticSubarrays(vector<int>& nums, vector<int>& l, vector<int>& r) {
        
        vector<bool> result;
        for (int i = 0; i < l.size(); i++) {
            vector<int> temp;
            for (int j = l[i]; j <= r[i]; j++) {
                temp.push_back(nums[j]);
            }
            sort(temp.begin(), temp.end());
            int diff = temp[1] - temp[0];
            bool isArithmetic = true;
            for (int j = 1; j < temp.size() - 1; j++) {
                if (temp[j + 1] - temp[j] != diff) {
                    isArithmetic = false;
                    break;
                }
            }
            result.push_back(isArithmetic);
        }
        return result;
    }
};