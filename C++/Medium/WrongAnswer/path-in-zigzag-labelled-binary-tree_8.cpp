class Solution {
public:
    vector<int> pathInZigZagTree(int label) {
        
        int row = 0;
        int sum = 0;
        while (sum < label) {
            sum += pow(2, row);
            row++;
        }
        int left = sum - pow(2, row - 1) + 1;
        int right = sum;
        int mid = (left + right) / 2;
        if (row % 2 == 0) {
            if (label < mid) {
                label = right - (label - left);
            } else {
                label = left + (right - label);
            }
        }
        vector<int> result;
        for (int i = row; i > 0; i--) {
            result.push_back(label);
            label = label / 2;
            left = pow(2, i - 2);
            right = pow(2, i - 1) - 1;
            mid = (left + right) / 2;
            if (i % 2 == 0) {
                if (label < mid) {
                    label = right - (label - left);
                } else {
                    label = left + (right - label);
                }
            }
        }
        reverse(result.begin(), result.end());
        return result;
    }
};