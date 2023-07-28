class Solution {
public:
    int divisorSubstrings(int num, int k) {
        
        string s = to_string(num);
        int n = s.size();
        int ans = 0;
        for (int i = 0; i <= n - k; ++i) {
            int x = stoi(s.substr(i, k));
            if (x && num % x == 0) {
                ans++;
            }
        }
        return ans;
    }
};