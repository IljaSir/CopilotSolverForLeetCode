class Solution {
public:
    int maximum69Number (int num) {
        
        int res = 0;
        int tmp = 0;
        vector<int> v;
        while (num != 0) {
            tmp = num % 10;
            if (tmp == 6) {
                v.push_back(9);
            } else {
                v.push_back(tmp);
            }
            num /= 10;
        }
        for (int i = v.size() - 1; i >= 0; i--) {
            res = res * 10 + v[i];
        }
        return res;
    }
};