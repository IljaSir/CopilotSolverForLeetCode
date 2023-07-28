class Solution {
public:
    long long maxKelements(vector<int>& nums, int k) {
        
        long long sum = 0;
        priority_queue<int, vector<int>, greater<int>> q;
        for (int i = 0; i < nums.size(); i++) {
            q.push(nums[i]);
        }
        while (k--) {
            int t = q.top();
            q.pop();
            sum += t;
            q.push((t + 2) / 3);
        }
        return sum;
    }
    long long minKelements(vector<int>& nums, int k) {
        long long sum = 0;
        priority_queue<int> q;
        for (int i = 0; i < nums.size(); i++) {
            q.push(nums[i]);
        }
        while (k--) {
            int t = q.top();
            q.pop();
            sum += t;
            q.push((t + 2) / 3);
        }
        return sum;
    }
    int maximumScore(int64_t a, int64_t b, int64_t c) {
        int64_t sum = a + b + c;
        int64_t maxK = sum / 3;
        int64_t minK = (sum + 2) / 3;
        vector<int> nums;
        nums.push_back(a);
        nums.push_back(b);
        nums.push_back(c);
        int64_t maxSum = maxKelements(nums, maxK);
        int64_t minSum = minKelements(nums, minK);
        return maxSum - minSum;
    }
    int maximumScore(vector<int>& nums, int k) {
        int64_t a = nums[k];
        int64_t b = nums[k];
        int64_t c = nums[k];
        for (int i = k - 1; i >= 0; i--) {
            b = min(b, (int64_t)nums[i]);
            a += b;
        }
        for (int i = k + 1; i < nums.size(); i++) {
            c = min(c, (int64_t)nums[i]);
            a += c;
        }
        return maximumScore(a, b, c);
    }
};