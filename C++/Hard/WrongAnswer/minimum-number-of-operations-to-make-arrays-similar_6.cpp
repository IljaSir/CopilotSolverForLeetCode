class Solution {
public:
    long long makeSimilar(vector<int>& nums, vector<int>& target) {
        
        long long sum1 = 0, sum2 = 0;
        for (int i = 0; i < nums.size(); i++) {
            sum1 += nums[i];
            sum2 += target[i];
        }
        if (sum1 != sum2) return -1;
        long long res = 0;
        for (int i = 0; i < nums.size(); i++) {
            int diff = nums[i] - target[i];
            if (diff > 0) res += diff / 2;
        }
        return res;
    }
};