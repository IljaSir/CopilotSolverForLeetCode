class Solution {
public:
    vector<int> minOperations(string boxes) {
        
        vector<int> res(boxes.size());
        int n = boxes.size();
        int left = 0;
        int right = 0;
        int cnt = 0;
        for (int i = 0; i < n; ++i) {
            if (boxes[i] == '1') {
                right += i;
                cnt += 1;
            }
        }
        res[0] = right;
        for (int i = 1; i < n; ++i) {
            if (boxes[i - 1] == '1') {
                cnt -= 1;
                left += i - 1;
            }
            res[i] = left + right - cnt * i;
        }
        return res;
    }
};