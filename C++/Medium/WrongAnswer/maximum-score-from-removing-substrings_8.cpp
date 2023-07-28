class Solution {
public:
    int maximumGain(string s, int x, int y) {
        
        int ans = 0;
        int n = s.size();
        string t = "ab";
        if (y > x) {
            swap(x, y);
            swap(t[0], t[1]);
        }
        // t[0] < t[1]
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < n) {
            if (s[i] == t[0]) {
                j++;
            } else if (s[i] == t[1]) {
                if (j > 0) {
                    ans += x;
                    j--;
                } else {
                    s[k++] = t[1];
                }
            } else {
                while (j > 0) {
                    s[k++] = t[0];
                    j--;
                }
                s[k++] = s[i];
            }
            i++;
        }
        while (j > 0) {
            s[k++] = t[0];
            j--;
        }
        s.resize(k);
        // cout << s << endl;
        i = 0;
        j = 0;
        k = 0;
        while (i < n) {
            if (s[i] == t[0]) {
                j++;
            } else if (s[i] == t[1]) {
                if (j > 0) {
                    ans += y;
                    j--;
                } else {
                    s[k++] = t[1];
                }
            } else {
                while (j > 0) {
                    s[k++] = t[0];
                    j--;
                }
                s[k++] = s[i];
            }
            i++;
        }
        while (j > 0) {
            s[k++] = t[0];
            j--;
        }
        s.resize(k);
        // cout << s << endl;
        return ans;
    }
};