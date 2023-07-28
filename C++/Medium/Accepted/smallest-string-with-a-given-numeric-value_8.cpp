class Solution {
public:
    string getSmallestString(int n, int k) {
        
        string ret(n, 'a');
        int i = n - 1;
        k -= n;
        while (k > 0) {
            int c = min(k, 25);
            ret[i--] += c;
            k -= c;
        }
        return ret;
    }
};