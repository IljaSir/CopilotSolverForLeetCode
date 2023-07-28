class Solution {
public:
    int minMoves(vector<int>& nums, int k) {
        
        vector<int> onePos;
        for (int i = 0; i < nums.size(); i++) {
            if (nums[i] == 1) {
                onePos.push_back(i);
            }
        }
        int n = onePos.size();
        vector<int> onePosSum(n + 1);
        for (int i = 1; i <= n; i++) {
            onePosSum[i] = onePosSum[i - 1] + onePos[i - 1];
        }
        int res = INT_MAX;
        for (int i = 0; i < n - k + 1; i++) {
            int j = i + k - 1;
            int mid = i + (j - i) / 2;
            int leftSum = onePosSum[mid + 1] - onePosSum[i];
            int rightSum = onePosSum[j + 1] - onePosSum[mid + 1];
            res = min(res, (mid - i + 1) * onePos[mid] - leftSum + rightSum - (j - mid) * onePos[mid]);
        }
        return res;
    }
};