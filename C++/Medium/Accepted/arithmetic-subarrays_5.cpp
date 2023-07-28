class Solution {
public:
    vector<bool> checkArithmeticSubarrays(vector<int>& nums, vector<int>& l, vector<int>& r) {
        
        vector<bool> res;
        for(int i = 0; i < l.size(); i++){
            vector<int> sub;
            for(int j = l[i]; j <= r[i]; j++){
                sub.push_back(nums[j]);
            }
            sort(sub.begin(), sub.end());
            bool isArithmetic = true;
            for(int j = 1; j < sub.size() - 1; j++){
                if(sub[j + 1] - sub[j] != sub[j] - sub[j - 1]){
                    isArithmetic = false;
                    break;
                }
            }
            res.push_back(isArithmetic);
        }
        return res;
    }
};