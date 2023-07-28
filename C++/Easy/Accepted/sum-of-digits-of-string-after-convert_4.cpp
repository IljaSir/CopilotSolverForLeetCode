class Solution {
public:
    int getLucky(string s, int k) {
        
        int n = s.size();
        string str = "";
        for (int i = 0; i < n; i++) {
            str += to_string(s[i] - 'a' + 1);
        }
        int sum = 0;
        for (int i = 0; i < str.size(); i++) {
            sum += str[i] - '0';
        }
        int res = sum;
        for (int i = 1; i < k; i++) {
            sum = 0;
            while (res) {
                sum += res % 10;
                res /= 10;
            }
            res = sum;
        }
        return res;
    }
};