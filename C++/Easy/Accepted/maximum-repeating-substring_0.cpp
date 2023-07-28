class Solution {
public:
    int maxRepeating(string sequence, string word) {
        
        int n = sequence.size();
        int m = word.size();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (sequence[i] == word[0]) {
                int cnt = 0;
                int j = i;
                while (j < n) {
                    bool flag = true;
                    for (int k = 0; k < m; k++) {
                        if (j + k >= n || sequence[j + k] != word[k]) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        cnt++;
                        j += m;
                    } else {
                        break;
                    }
                }
                ans = max(ans, cnt);
            }
        }
        return ans;
    }
};