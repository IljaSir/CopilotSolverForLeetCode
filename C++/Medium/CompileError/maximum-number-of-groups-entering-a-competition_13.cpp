class Solution {
public:
    int maximumGroups(vector<int>& grades) {
        
        int n = grades.size();
        int ans = 0;
        vector<int> cnt(100001);
        for(int i = 0; i < n; i++)
            cnt[grades[i]]++;
        for(int i = 1; i <= 100000; i++)
            if(cnt[i] > 0)
                if(cnt[i - 1] > 0) {
                    int t = min(cnt[i], cnt[i - 1]);
                    cnt[i] -= t;
                    cnt[i - 1] -= t;
                    ans += t;
                }
        for(int i = 2; i <= 100000; i++)
            if(cnt[i] > 0)
                if(cnt[i - 2] > 0) {
                    int t = min(cnt[i], cnt[i - 2]);
                    cnt[i] -= t;
                    cnt[i - 2] -= t;
                    ans += t;
                }
        for(int i = 3; i <= 100000; i++)
            if(cnt[i] > 0)
                if(cnt[i - 3] > 0) {
                    int t = min(cnt[i], cnt[i - 3]);
                    cnt[i] -= t;
                    cnt[i - 3] -= t;
                    ans += t;
                }
        for(int i = 4; i <= 100000; i++)
            if(cnt[i] > 0)
                if(cnt[i - 4] > 0) {
                    int t = min(cnt[i], cnt[i - 4]);
                    cnt[i] -= t;
                    cnt[i= t;
    }
};