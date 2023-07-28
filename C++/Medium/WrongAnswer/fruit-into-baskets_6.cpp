class Solution {
public:
    int totalFruit(vector<int>& fruits) {
        
        int i = 0, j = 0, k = 0, n = fruits.size(), res = 0;
        while (j < n) {
            if (fruits[i] == fruits[j]) {
                j++;
            } else if (k == 0) {
                k = fruits[j++];
            } else if (fruits[k] == fruits[j]) {
                j++;
            } else {
                i = j - 1;
                while (fruits[i - 1] == fruits[i]) i--;
                k = fruits[j++];
            }
            res = max(res, j - i);
        }
        return res;
    }
};