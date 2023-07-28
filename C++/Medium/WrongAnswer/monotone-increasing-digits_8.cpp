class Solution {
public:
    int monotoneIncreasingDigits(int n) {
        
        vector<int> v;
        while (n) {
            v.push_back(n % 10);
            n /= 10;
        }
        reverse(v.begin(), v.end());
        int i = 0;
        for (i = 0; i < v.size() - 1; i++) {
            if (v[i] > v[i + 1]) {
                break;
            }
        }
        if (i == v.size() - 1) {
            return n;
        }
        for (int j = i + 1; j < v.size(); j++) {
            v[j] = 9;
        }
        v[i]--;
        for (int j = i - 1; j >= 0; j--) {
            if (v[j] > v[j + 1]) {
                v[j]--;
                v[j + 1] = 9;
            }
        }
        int ans = 0;
        for (int j = 0; j < v.size(); j++) {
            ans = ans * 10 + v[j];
        }
        return ans;
    }
};