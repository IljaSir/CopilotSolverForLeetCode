class Solution {
public:
    string getSmallestString(int n, int k) {
        
        string ans;
        for (int i = n-1; i >= 0; --i) {
            int x = min(26, k - i);
            ans += 'a' + x - 1;
            k -= x;
        }
        return ans;
    }
};