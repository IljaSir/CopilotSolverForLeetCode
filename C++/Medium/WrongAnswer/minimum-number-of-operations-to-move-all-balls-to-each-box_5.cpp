class Solution {
public:
    vector<int> minOperations(string boxes) {
        
        int n = boxes.size();
        vector<int> left(n, 0), right(n, 0);
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (i > 0) {
                left[i] = left[i - 1];
            }
            if (boxes[i] == '1') {
                cnt++;
                left[i] += cnt;
            }
        }
        cnt = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (i < n - 1) {
                right[i] = right[i + 1];
            }
            if (boxes[i] == '1') {
                cnt++;
                right[i] += cnt;
            }
        }
        for (int i = 0; i < n; i++) {
            left[i] += right[i];
        }
        return left;
    }
};