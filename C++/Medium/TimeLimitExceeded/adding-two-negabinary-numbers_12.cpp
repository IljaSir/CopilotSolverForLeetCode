class Solution {
public:
    vector<int> addNegabinary(vector<int>& arr1, vector<int>& arr2) {
        
        int N = arr1.size();
        int M = arr2.size();
        int i = N - 1;
        int j = M - 1;
        int carry = 0;
        vector<int> res;
        while (i >= 0 || j >= 0 || carry != 0) {
            int x = i >= 0 ? arr1[i--] : 0;
            int y = j >= 0 ? arr2[j--] : 0;
            int sum = x + y + carry;
            if (sum == 0) {
                res.push_back(0);
                carry = 0;
            } else if (sum == 1) {
                res.push_back(1);
                carry = 0;
            } else if (sum == 2) {
                res.push_back(0);
                carry = -1;
            } else if (sum == 3) {
                res.push_back(1);
                carry = -1;
            }
        }
        while (res.size() > 1 && res.back() == 0) {
            res.pop_back();
        }
        reverse(res.begin(), res.end());
        return res;
    }
};