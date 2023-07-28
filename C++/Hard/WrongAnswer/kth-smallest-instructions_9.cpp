class Solution {
public:
    string kthSmallestPath(vector<int>& destination, int k) {
        
        string ans;
        int r = destination[0], c = destination[1];
        int n = r + c;
        int m = r;
        int cnt = 1;
        while (r > 0 && c > 0) {
            int tmp = cnt;
            for (int i = 1; i <= c; ++i) {
                tmp *= (m + n - i);
                tmp /= i;
            }
            if (tmp >= k) {
                ans.push_back('H');
                --n;
                --c;
            } else {
                ans.push_back('V');
                --m;
                --r;
                k -= tmp;
            }
            cnt = tmp;
        }
        while (r > 0) {
            ans.push_back('V');
            --m;
            --r;
        }
        while (c > 0) {
            ans.push_back('H');
            --n;
            --c;
        }
        return ans;
    }
};