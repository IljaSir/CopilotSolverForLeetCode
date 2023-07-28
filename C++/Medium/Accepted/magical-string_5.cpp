class Solution {
public:
    int magicalString(int n) {
        
        if (n == 0) return 0;
        if (n <= 3) return 1;
        vector<int> s(n + 1, 0);
        s[0] = 1;
        s[1] = 2;
        s[2] = 2;
        int i = 2;
        int j = 3;
        int num = 1;
        int ans = 1;
        while (j < n) {
            for (int k = 0; k < s[i]; k++) {
                s[j] = num;
                if (num == 1 && j < n) ans++;
                j++;
            }
            num = 3 - num;
            i++;
        }
        return ans;
    }
};