class Solution {
public:
    vector<int> constructArray(int n, int k) {
        
        vector<int> res;
        int left = 1, right = n;
        while (left <= right) {
            if (k > 1) {
                res.push_back(k-- % 2 ? left++ : right--);
            } else {
                res.push_back(left++);
            }
        }
        return res;
    }
};