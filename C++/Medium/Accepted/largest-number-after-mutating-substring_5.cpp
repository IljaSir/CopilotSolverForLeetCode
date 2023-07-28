class Solution {
public:
    string maximumNumber(string num, vector<int>& change) {
        
        int n = num.size();
        bool mutated = false;
        for (int i = 0; i < n; ++i) {
            int d = num[i] - '0';
            if (change[d] > d) {
                num[i] = change[d] + '0';
                mutated = true;
            } else if (change[d] < d) {
                if (mutated) {
                    break;
                }
            }
        }
        return num;
    }
};