class Solution {
public:
    vector<int> minOperations(string boxes) {
        
        int n = boxes.length();
        vector<int> ans(n);
        int sum = 0;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            ans[0] += sum;
            cnt += boxes[i] - '0';
            sum += cnt;
        }
        sum = 0;
        cnt = 0;
        for (int i = n - 1; i >= 0; i--) {
            ans[i] += sum;
            cnt += boxes[i] - '0';
            sum += cnt;
        }
        return ans;
    }
};