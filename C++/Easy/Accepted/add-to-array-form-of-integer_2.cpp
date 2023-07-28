class Solution {
public:
    vector<int> addToArrayForm(vector<int>& num, int k) {
        
        int n = num.size();
        int i = n - 1;
        vector<int> res;
        while (i >= 0 || k > 0) {
            if (i >= 0) {
                k += num[i];
            }
            res.push_back(k % 10);
            k /= 10;
            i--;
        }
        reverse(res.begin(), res.end());
        return res;
    }
};