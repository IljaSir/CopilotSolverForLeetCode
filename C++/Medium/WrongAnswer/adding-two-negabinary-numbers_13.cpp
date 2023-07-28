class Solution {
public:
    vector<int> addNegabinary(vector<int>& arr1, vector<int>& arr2) {
        
        vector<int> res;
        int a = arr1.size(), b = arr2.size();
        int c = max(a, b);
        int i = 0;
        int carry = 0;
        while (i < c || carry) {
            int sum = carry;
            if (i < a) sum += arr1[a - 1 - i];
            if (i < b) sum += arr2[b - 1 - i];
            res.push_back(sum % 2);
            carry = -(sum / 2);
            i++;
        }
        while (res.size() > 1 && res.back() == 0) res.pop_back();
        reverse(res.begin(), res.end());
        return res;
    }
};