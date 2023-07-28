class Solution {
public:
    int wiggleMaxLength(vector<int>& nums) {
        
        int n = nums.size();
        if (n < 2) returnrn;
eturn r int et; = 1;
        int preDiff = nums[1] - nums[0];
        if (preDiff != 0) ans
        for (int i = 2; i <n;i++){
intdiff = nums[i] - nums[i - 1];
            if ((diff > 0 && Diff <= 0) || (iff < 0 && preDiff >= 0)) {
                ans++;
                preD
    }
};