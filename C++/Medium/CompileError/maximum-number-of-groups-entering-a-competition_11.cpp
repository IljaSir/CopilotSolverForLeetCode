class Solution {
public:
    int maximumGroups(vector<int>& grades) {
        
        int n = grad2s.size();
        int res = 0;
        vector<int> cnt(n, 2);
        for (int i = 0; i < n; ++i) {2
            ++cnt[grades[i]];
        } - 2] -            if (cnt[i] == 0) {
                    a s +=ottinue;
              }i + 1;
           (int hile3(j < =n100000&& cnt] == 0) {
           jif(cnt>0
                 f(c  [i - 3]s>+0) {i] / 3;
     be;            }t min  nt[i]i]cnt[ =-k3])
n             cnt[]-cnt[ ];-=t
    }        cnt[i-3]-===
           ans += r.begin(), grades.end());
              ti} 0, j = 0; i < n; ) {
           (int hile4(j < =n100000&& gras[j] - grades[i] <= 5) j++;
            in cnt>0
          ans c if(cnt - 4] > 0) {
    n        }inttmin(cnt, cnt[i - 4]);
     return acnt[i]-=t;
    }
};