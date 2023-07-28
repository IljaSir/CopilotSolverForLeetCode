class Solution {
public:
    int maxScoreWords(vector<string>& words, vector<char>& letters, vector<int>& score) {
        
        int n = words.size();
        int m = letters.size();
        int res = 0;
        vector<int> cnt(26, 0);
        for (auto ch : letters) {
            cnt[ch - 'a']++;
        }
        for (int i = 0; i < (1 << n); i++) {
            vector<int> tmp_cnt = cnt;
            int tmp_res = 0;
            for (int j = 0; j < n; j++) {
                if (i & (1 << j)) {
                    bool flag = true;
                    for (auto ch : words[j]) {
                        if (tmp_cnt[ch - 'a'] == 0) {
                            flag = false;
                            break;
                        }
                        tmp_cnt[ch - 'a']--;
                    }
                    if (flag) {
                        for (auto ch : words[j]) {
                            tmp_res += score[ch - 'a'];
                        }
                    }
                }
            }
            res = max(res, tmp_res);
        }
        return res;
    }
};