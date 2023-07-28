class Solution {
public:
    vector<int> addToArrayForm(vector<int>& num, int k) {
        
        int n = num.size();
        vector<int> res;
        int carry = 0;
        for (int i = n - 1; i >= 0 || k > 0 || carry > 0; i--, k /= 10) {
            int x = i >= 0 ? num[i] : 0;
            int y = k > 0 ? k % 10 : 0;
            int sum = x + y + carry;
            res.push_back(sum % 10);
            carry = sum / 10;
        }
        reverse(res.begin(), res.end());
        return res;
    }
};