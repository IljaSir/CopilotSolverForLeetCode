class Solution {
public:
    vector<int> minOperations(string boxes) {
        
        int n = boxes.size();
        vector<int> ans(n, 0);
        int count = 0;
        int dist = 0;
        for (int i = 0; i < n; i++) {
            ans[i] += dist;
            count += boxes[i] - '0';
            dist += count;
        }
        count = 0;
        dist = 0;
        for (int i = n - 1; i >= 0; i--) {
            ans[i] += dist;
            count += boxes[i] - '0';
            dist += count;
        }
        return ans;
    }
};