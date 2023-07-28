class Solution {
public:
    int totalFruit(vector<int>& fruits) {
        
        int n = fruits.size();
        int res = 0;
        int i = 0;
        int j = 0;
        int k = 0;
        for (int j = 1; j < n; j++) {
            if (fruits[j] == fruits[j - 1]) continue;
            if (k == 0) k = j;
            else if (fruits[k] != fruits[j]) {
                res = max(res, j - i);
                i = k;
                k = j;
            }
        }
        return max(res, n - i);
    }
};