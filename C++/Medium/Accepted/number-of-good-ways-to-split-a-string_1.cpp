class Solution {
public:
    int numSplits(string s) {
        
        int n = s.size();
        vector<int> left(26, 0), right(26, 0);
        for (char c : s) {
            right[c - 'a']++;
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            left[s[i] - 'a']++;
            right[s[i] - 'a']--;
            int left_cnt = 0, right_cnt = 0;
            for (int j = 0; j < 26; j++) {
                if (left[j] > 0) left_cnt++;
                if (right[j] > 0) right_cnt++;
            }
            if (left_cnt == right_cnt) res++;
        }
        return res;
    }
};