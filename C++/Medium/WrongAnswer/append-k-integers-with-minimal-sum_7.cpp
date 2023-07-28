class Solution {
public:
    long long minimalKSum(vector<int>& nums, int k) {
        
        long long sum = 0;
        for (int n : nums) {
            sum += n;
        }
        priority_queue<int> pq(nums.begin(), nums.end());
        while (k--) {
            int n = pq.top(); pq.pop();
            sum += n;
            pq.push(n - 1);
        }
        return sum;
    }
};