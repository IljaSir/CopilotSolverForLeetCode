class Solution {
public:
    int largestSumAfterKNegations(vector<int>& nums, int k) {
        
        // sort(nums.begin(), nums.end());
        // int i = 0;
        // while (k > 0 && i < nums.size()) {
        //     if (nums[i] < 0) {
        //         nums[i] = -nums[i];
        //         k--;
        //     } else if (nums[i] == 0) {
        //         break;
        //     } else {
        //         if (k % 2 == 1) {
        //             nums[i] = -nums[i];
        //             k = 0;
        //         }
        //     }
        //     i++;
        // }
        // int sum = 0;
        // for (int n : nums) {
        //     sum += n;
        // }
        // return sum;
        priority_queue<int, vector<int>, greater<int>> pq;
        for (int n : nums) {
            pq.push(n);
        }
        while (k > 0) {
            int n = pq.top();
            pq.pop();
            pq.push(-n);
            k--;
        }
        int sum = 0;
        while (!pq.empty()) {
            sum += pq.top();
            pq.pop();
        }
        return sum;
    }
};