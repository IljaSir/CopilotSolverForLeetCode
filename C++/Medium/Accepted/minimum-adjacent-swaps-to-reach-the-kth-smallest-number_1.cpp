class Solution {
public:
    int getMinSwaps(string num, int k) {
        
        int ans = 0;
        string cur = num;
        while (k--) {
            next_permutation(cur.begin(), cur.end());
        }
        for (int i = 0; i < num.size(); ++i) {
            if (num[i] != cur[i]) {
                for (int j = i + 1; j < num.size(); ++j) {
                    if (cur[j] == num[i]) {
                        ans += j - i;
                        while (j > i) {
                            swap(cur[j], cur[j - 1]);
                            --j;
                        }
                        break;
                    }
                }
            }
        }
        return ans;
    }
};