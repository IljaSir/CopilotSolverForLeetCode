class Solution {
public:
    int numWays(string s) {
        
        int n = s.length();
        int one = 0;
        for(int i = 0; i < n; i++) {
            one += (s[i] == '1');
        }
        if(one % 3 != 0) {
            return 0;
        }
        if(one == 0) {
            return (long long)(n - 1) * (n - 2) / 2 % 1000000007;
        }
        int target = one / 3;
        int cur = 0, first = 0, second = 0;
        for(int i = 0; i < n; i++) {
            if(s[i] == '1') {
                cur++;
            }
            if(cur == target) {
                first = i;
                break;
            }
        }
        for(int i = first + 1; i < n; i++) {
            if(s[i] == '1') {
                cur++;
            }
            if(cur == 2 * target) {
                second = i;
                break;
            }
        }
        return (long long)(first + 1) * (second - first) % 1000000007;
    }
};