class Solution {
public:
    int maximumCount(vector<int>& nums) {
        
        int pos = 0, neg = 0;
        int maxCount = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (nums[i] >= 0) {
                pos++;
                neg = 0;
            } else {
                neg++;
                pos = 0;
            }
            maxCount = max(maxCount, max(pos, neg));
        }
        return maxCount;
    }
};