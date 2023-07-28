class Solution {
public:
    int deleteAndEarn(vector<int>& nums) {
        
        int maxNum = 0;
        for (int num : nums) {
            maxNum = max(maxNum, num);
        }
        vector<int> sum(maxNum + 1, 0);
        for (int num : nums) {
            sum[num] += num;
        }
        int first = sum[0], second = max(sum[0], sum[1]);
        for (int i = 2; i <= maxNum; i++) {
            int temp = second;
            second = max(first + sum[i], second);
            first = temp;
        }
        return second;
    }
};