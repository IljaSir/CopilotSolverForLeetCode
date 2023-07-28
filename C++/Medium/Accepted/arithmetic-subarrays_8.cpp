class Solution {
public:
    vector<bool> checkArithmeticSubarrays(vector<int>& nums, vector<int>& l, vector<int>& r) {
        
        vector<bool> ret;
        int n = l.size();
        for(int i = 0; i < n; i++) {
            int start = l[i];
            int end = r[i];
            vector<int> sub;
            for(int j = start; j <= end; j++) {
                sub.push_back(nums[j]);
            }
            sort(sub.begin(), sub.end());
            int diff = sub[1] - sub[0];
            bool isArithmetic = true;
            for(int k = 2; k < sub.size(); k++) {
                if(sub[k] - sub[k-1] != diff) {
                    isArithmetic = false;
                    break;
                }
            }
            ret.push_back(isArithmetic);
        }
        return ret;
    }
};