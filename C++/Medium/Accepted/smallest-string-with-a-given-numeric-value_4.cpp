class Solution {
public:
    string getSmallestString(int n, int k) {
        
        string res;
        for (int i = 0; i < n; i++) {
            res += 'a';
        }
        k -= n;
        for (int i = n - 1; i >= 0; i--) {
            if (k > 25) {
                res[i] = 'z';
                k -= 25;
            } else {
                res[i] += k;
                break;
            }
        }
        return res;
    }
};