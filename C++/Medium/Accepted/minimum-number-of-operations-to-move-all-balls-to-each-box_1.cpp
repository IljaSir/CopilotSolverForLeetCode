class Solution {
public:
    vector<int> minOperations(string boxes) {
        
        vector<int> ans;
        int n = boxes.size();
        for (int i = 0; i < n; i++) {
            int op = 0;
            for (int j = 0; j < n; j++) {
                if (boxes[j] == '1') {
                    op += abs(i - j);
                }
            }
            ans.push_back(op);
        }
        return ans;
    }
};