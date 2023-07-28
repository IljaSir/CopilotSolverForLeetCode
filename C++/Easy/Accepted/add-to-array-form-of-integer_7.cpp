class Solution {
public:
    vector<int> addToArrayForm(vector<int>& num, int k) {
        
        int n = num.size();
        int carry = 0;
        for (int i = n-1; i >= 0; i--) {
            int sum = num[i] + k%10 + carry;
            carry = sum/10;
            num[i] = sum%10;
            k /= 10;
        }
        while (k > 0) {
            int sum = k%10 + carry;
            carry = sum/10;
            num.insert(num.begin(), sum%10);
            k /= 10;
        }
        if (carry > 0) {
            num.insert(num.begin(), carry);
        }
        return num;
    }
};