class Solution {
public:
    long long maxKelements(vector<int>& nums, int k) {
        
        priority_queue<int> pq;
        for (int i = 0; i < nums.size(); i++) {
            pq.push(nums[i]);
        }
        while (k-- > 0) {
            int val = pq.top(); pq.pop();
            pq.push(val/3);
        }
        long long sum = 0;
        while (!pq.empty()) {
            sum += pq.top(); pq.pop();
        }
        return sum;
    }
    long long maxScore(vector<int>& nums, int k) {
        long long sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        long long res = sum;
        for (int i = k; i < nums.size(); i++) {
            sum += nums[i];
            sum -= nums[i-k];
            res = max(res, sum);
        }
        return res + maxKelements(nums, k);
    }
};