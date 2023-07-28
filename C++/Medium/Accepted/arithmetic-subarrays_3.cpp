class Solution {
public:
    vector<bool> checkArithmeticSubarrays(vector<int>& nums, vector<int>& l, vector<int>& r) {
        
        vector<bool> res;
        for (int i = 0; i < l.size(); i++) {
            vector<int> sub;
            for (int j = l[i]; j <= r[i]; j++) {
                sub.push_back(nums[j]);
            }
            sort(sub.begin(), sub.end());
            bool isArithmetic = true;
            for (int j = 1; j < sub.size(); j++) {
                if (sub[j] - sub[j-1] != sub[1] - sub[0]) {
                    isArithmetic = false;
                    break;
                }
            }
            res.push_back(isArithmetic);
        }
        return res;
    }
};