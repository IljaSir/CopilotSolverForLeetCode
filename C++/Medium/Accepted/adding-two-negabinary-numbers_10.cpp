class Solution {
public:
    vector<int> addNegabinary(vector<int>& arr1, vector<int>& arr2) {
        
        vector<int> res;
        int carry = 0;
        for (int i = arr1.size() - 1, j = arr2.size() - 1; i >= 0 || j >= 0 || carry != 0; i--, j--) {
            int sum = (i >= 0 ? arr1[i] : 0) + (j >= 0 ? arr2[j] : 0) + carry;
            res.push_back(sum & 1);
            carry = -(sum >> 1);
        }
        while (res.size() > 1 && res.back() == 0) {
            res.pop_back();
        }
        reverse(res.begin(), res.end());
        return res;
    }
};