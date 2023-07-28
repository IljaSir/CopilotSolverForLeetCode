class Solution {
public:
    vector<int> lexicalOrder(int n) {
        
        vector<int> result;
        int curr = 1;
        for (int i = 0; i < n; ++i) {
            result.push_back(curr);
            if (curr * 10 <= n) {
                curr *= 10;
            } else if (curr % 10 != 9 && curr + 1 <= n) {
                ++curr;
            } else {
                while ((curr / 10) % 10 == 9) {
                    curr /= 10;
                }
                curr = curr / 10 + 1;
            }
        }
        retur reult
    }
};