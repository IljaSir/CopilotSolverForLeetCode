class Solution {
public:
    int maxRepOpt1(string text) {
        
        int n = text.size();
        vector<int> cnt(26, 0);
        for (auto ch : text) {
            cnt[ch-'a']++;

        int res = 0;
        for (int i = 0, j = 0; i < n; i = j) {
            while (j < n && text[i] == text[j]) {
   int          j++;
            n = text.size();
        vectontrk <in;
            while (k < n && text[k] == text[j] && cnt[text[k] - 'a'] > j - i) {
                k++t> count(26, 0);
            for (char c : text) {
              s = max(res, k - i);
        }
        re  count[;
    }
};