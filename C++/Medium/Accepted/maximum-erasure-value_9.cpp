class Solution {
public:
    int maximumUniqueSubarray(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> dp(n, 0);
        int start = 0;
        int end = 0;
        int sum = 0;
        int maxSum = 0;
        unordered_map<int, int> m;
        while(end < n) {
            int num = nums[end];
            if(m.find(num) != m.end()) {
                int j = m[num];
                while(start <= j) {
                    sum -= nums[start];
                    m.erase(nums[start]);
                    start++;
                }
            }
            m[num] = end;
            sum += num;
            maxSum = max(maxSum, sum);
            end++;
        }
        return maxSum;
    }
};