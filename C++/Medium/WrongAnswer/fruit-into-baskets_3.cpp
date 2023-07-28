class Solution {
public:
    int totalFruit(vector<int>& fruits) {
        
        int n = fruits.size();
        int ans = 0;
        int i = 0;
        for (int j = 0; j < n; ++j) {
            if (j == n - 1 || fruits[j] != fruits[j + 1]) {
                int k = j + 1;
                while (k < n && fruits[k] == fruits[j]) ++k;
                int cnt = k - i;
                int pre = 0;
                for (int p = i - 1; p >= 0 && fruits[p] == fruits[i - 1]; --p) pre++;
                cnt += pre;
                ans = max(ans, cnt);
                i = k;
            }
        }
        return ans;
    }
};