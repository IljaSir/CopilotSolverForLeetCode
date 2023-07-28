class Solution {
public:
    int maximumCount(vector<int>& nums) {
        
        int pos = 0, neg = 0, res = 0;
        for (auto num : nums) {
            if (num > 0) {
                pos++;
                neg = 0;
            } else if (num < 0) {
                neg++;
                pos = 0;
            } else {
                pos = neg = 0;
            }
            res = max(res, max(pos, neg));
        }
        return res;
    }
};