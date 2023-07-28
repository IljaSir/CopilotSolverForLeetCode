class Solution {
public:
    vector<bool> checkArithmeticSubarrays(vector<int>& nums, vector<int>& l, vector<int>& r) {
        
        vector<bool> result;
        int n = l.size();
        for (int i = 0; i < n; ++i) {
            vector<int> temp;
            for (int j = l[i]; j <= r[i]; ++j) {
                temp.push_back(nums[j]);
            }
            sort(temp.begin(), temp.end());
            int diff = temp[1] - temp[0];
            bool flag = true;
            for (int j = 2; j < temp.size(); ++j) {
                if (temp[j] - temp[j - 1] != diff) {
                    flag = false;
                    break;
                }
            }
            result.push_back(flag);
        }
        return result;
    }
};