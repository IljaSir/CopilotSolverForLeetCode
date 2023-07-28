class Solution {
public:
    string getSmallestString(int n, int k) {
        
        string result(n, 'a');
        k -= n;
        for (int i = n - 1; i >= 0 && k > 0; i--) {
            int diff = min(k, 25);
            result[i] += diff;
            k -= diff;
        }
        return result;
    }
};