class Solution {
public:
    vector<int> addToArrayForm(vector<int>& num, int k) {
        
        vector<int> res;
        int carry = 0;
        for (int i = num.size() - 1; i >= 0; i--) {
            int sum = num[i] + k % 10 + carry;
            k /= 10;
            res.push_back(sum % 10);
            carry = sum / 10;
        }
        for (; k > 0 || carry > 0; k /= 10) {
            int sum = k % 10 + carry;
            res.push_back(sum % 10);
            carry = sum / 10;
        }
        reverse(res.begin(), res.end());
        return res;
    }
};