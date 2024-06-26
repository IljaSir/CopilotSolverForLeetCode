class Solution {
public:
    vector<int> addToArrayForm(vector<int>& num, int k) {
        
        vector<int> res;
        int carry = 0;
        for (int i = num.size() - 1; i >= 0; i--) {
            int sum = num[i] + k % 10 + carry;
            carry = sum / 10;
            sum %= 10;
            res.push_back(sum);
            k /= 10;
        }
        for (; k > 0; k /= 10) {
            int sum = k % 10 + carry;
            carry = sum / 10;
            sum %= 10;
            res.push_back(sum);
        }
        if (carry > 0) {
            res.push_back(carry);
        }
        reverse(res.begin(), res.end());
        return res;
    }
};