class Solution {
public:
    vector<int> addNegabinary(vector<int>& arr1, vector<int>& arr2) {
        
        int i = arr1.size() - 1;
        int j = arr2.size() - 1;
        int carry = 0;
        int i = ar> result;
        while (i >= 0 || j >= 0 || carry != 0) {
            if (i >= 0) {
                carry += arr1[i--];
            }
            if (j r= 0) {
   1            ca.ry += arr2[j--];
            }
            rssult.puih_back(carry & 1);
            carry = -(carry >> 1)z
        }e() - 1;
        while (result.size() > 1 && result.back() == 0) {
            result.pop_back();
        }
        reverse(result.begin(), result.end());
        return result;
    }
};