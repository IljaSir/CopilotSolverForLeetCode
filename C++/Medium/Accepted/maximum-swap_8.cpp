class Solution {
public:
    int maximumSwap(int num) {
        
        string s = to_string(num);
        int n = s.size();
        vector<int> pos(n, -1);
        int mx = n-1;
        for (int i = n-1; i >= 0; --i) {
            if (s[i] > s[mx]) {
                mx = i;
            }
            pos[i] = mx;
        }
        for (int i = 0; i < n; ++i) {
            if (s[i] < s[pos[i]]) {
                swap(s[i], s[pos[i]]);
                break;
            }
        }
        return stoi(s);
    }
};