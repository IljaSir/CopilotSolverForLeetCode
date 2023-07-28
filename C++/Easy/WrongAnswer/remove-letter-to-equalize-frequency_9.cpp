class Solution {
public:
    bool equalFrequency(string word) {
        
        int n = word.length();
        if(n==2) return true;
        vector<int> cnt(26,0);
        for(int i=0; i<n; i++) cnt[word[i]-'a']++;
        int k = 0;
        for(int i=0; i<26; i++) if(cnt[i]) k++;
        if(k==1) return true;
        for(int i=0; i<26; i++) {
            if(cnt[i]) {
                cnt[i]--;
                int kk = 0;
                for(int j=0; j<26; j++) if(cnt[j]) kk++;
                if(kk==1) return true;
                for(int j=0; j<26; j++) {
                    if(cnt[j]) {
                        cnt[j]--;
                        kk = 0;
                        for(int l=0; l<26; l++) if(cnt[l]) kk++;
                        if(kk==1) return true;
                        cnt[j]++;
                    }
                }
                cnt[i]++;
            }
        }
        return false;
    }
};