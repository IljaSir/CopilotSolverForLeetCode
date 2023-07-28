class Solution {
public:
    bool isItPossible(string word1, string word2) {
        
        int n1 = word1.size();
        int n2 = word2.size();
        if(n1 != n2) return false;
        int cnt[26] = {0};
        for(int i = 0; i < n1; ++i) {
            ++cnt[word1[i]-'a'];
            --cnt[word2[i]-'a'];
        }
        int cnt1 = 0;
        int cnt2 = 0;
        for(int i = 0; i < 26; ++i) {
            if(cnt[i] > 0) ++cnt1;
            if(cnt[i] < 0) ++cnt2;
        }
        if(cnt1 == 0 && cnt2 == 0) return false;
        if(cnt1 == 1 || cnt2 == 1) return true;
        return false;
    }
    bool buddyStrings(string word1, string word2) {
        int n1 = word1.size();
        int n2 = word2.size();
        if(n1 != n2) return false;
        if(word1 == word2) {
            int cnt[26] = {0};
            for(int i = 0; i < n1; ++i) {
                ++cnt[word1[i]-'a'];
            }
            for(int i = 0; i < 26; ++i) {
                if(cnt[i] > 1) return true;
            }
            return false;
        }
        int diff = 0;
        int idx1 = -1;
        int idx2 = -1;
        for(int i = 0; i < n1; ++i) {
            if(word1[i] != word2[i]) {
                ++diff;
                if(diff > 2) return false;
                if(idx1 == -1) idx1 = i;
                else idx2 = i;
            }
        }
        if(diff != 2) return false;
        swap(word1[idx1], word1[idx2]);
        return word1 == word2;
    }
};