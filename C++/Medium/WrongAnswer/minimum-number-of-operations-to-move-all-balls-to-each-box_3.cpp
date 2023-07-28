class Solution {
public:
    vector<int> minOperations(string boxes) {
        
        int n = boxes.size();
        vector<int> ans(n, 0);
        int left = 0, right = 0;
        for (int i = 0; i < n; i++) {
            if (boxes[i] == '1') {
                right++;
            }
        }
        for (int i = 0; i < n; i++) {
            if (boxes[i] == '1') {
                right--;
            }
            ans[i] = left + right;
            if (boxes[i] == '1') {
                left++;
            }
        }
        return ans;
    }
};