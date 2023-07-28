class Solution {
public:
    int minAbsDifference(vector<int>& nums, int goal) {
        
        int n = nums.size();
        vector<int> left(n/2);
        vector<int> right(n-n/2);
        for (int i = 0; i < n/2; i++) {
            left[i] = nums[i];
        }
        for (int i = n/2; i < n; i++) {
            right[i-n/2] = nums[i];
        }
        vector<int> leftSum;
        vector<int> rightSum;
        getSum(left, 0, 0, leftSum);
        getSum(right, 0, 0, rightSum);
        sort(leftSum.begin(), leftSum.end());
        sort(rightSum.begin(), rightSum.end());
        int ans = INT_MAX;
        for (int i = 0; i < leftSum.size(); i++) {
            int x = leftSum[i];
            int y = rightSum[0];
            int l = 0;
            int r = rightSum.size()-1;
            while (l < r) {
                int mid = (l+r)/2;
                if (rightSum[mid] <= goal-x) l = mid+1;
                else r = mid;
            }
            if (abs(x+y-goal) < ans) ans = abs(x+y-goal);
            if (r > 0) {
                if (abs(x+rightSum[r-1]-goal) < ans) ans = abs(x+rightSum[r-1]-goal);
            }
            if (r < rightSum.size()) {
                if (abs(x+rightSum[r]-goal) < ans) ans = abs(x+rightSum[r]-goal);
            }
        }
        for (int i = 0; i < rightSum.size(); i++) {
            int x = rightSum[i];
            int y = leftSum[0];
            int l = 0;
            int r = leftSum.size()-1;
            while (l < r) {
                int mid = (l+r)/2;
                if (leftSum[mid] <= goal-x) l = mid+1;
                else r = mid;
            }
            if (abs(x+y-goal) < ans) ans = abs(x+y-goal);
            if (r > 0) {
                if (abs(x+leftSum[r-1]-goal) < ans) ans = abs(x+leftSum[r-1]-goal);
    }
};