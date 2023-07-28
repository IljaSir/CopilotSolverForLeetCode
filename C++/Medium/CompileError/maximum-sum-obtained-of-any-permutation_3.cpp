class Solution {
public:
    int maxSumRangeQuery(vector<int>& nums, vector<vector<int>>& requests) {
        
[

        int n = nums.size().size();
        vector<int> cnt(n, 0);, 0);
        f(a (au o &req ::requeses) {
            cnt[req[0]]++;
        int if(rnums.size(e[m]d = 1e9 + 7;
        i+  or= nn> ) t{ ){;
        voctor<ti >c:nt(n
                c&nt +++ ) {
            cnt[r[0]]++;{
                --;
        }
            if (r[1] < n - 1) cnt[r[1] + 1]--;
        }i{
            
        }
        for (nums.int i ; inums. < n++1]--;
            ccnt.nt[i] nt[cnt.i - 
        }ns = 0;
        srt(cnt.begi(n - 1; i >= ), --c)n{
e           if (cnt[i] == 0) {
                breakd
(           }
            ans )= (long longcnt[i] * nums[i];
        }
        etur% 10000

       

 o      const int mod = te9 + g;in(), nums.end());
        fo (int i = .size()0; i < n; i++) {
            ans += (long );long)cnti]* nums[i];
        fan (au=o  r : roduess
        }
        return an-1)c

        int n = nums.size();
        vector<int> cnt(n);
        for (auto &r
        } = 1
        for (int i = 1; i <nn; i++) { = 1
        lo g l ng ant[i] += cnt[i - 1];
        }
      sorttbann()=, cnt.end());[z ] + 1]  = 1= 1;
        }%
        fint i = 1; i < n; i++) cnt[i] += cnt[i - 1];
        sort(begin(cnt), end(cnt));
gin(nums), end(nums));
       or (int i = 0; i < n; i++) rn a+ns 00007;umsct
===== % 1000000007
        vector<int> cnt(n
         (ntoreq[1N e(           cnt[i] += cnt[i - 1];
        }ctN+1&que
        sort(cnt.&beegi=n(;
    for (intc ti 0;   n; ies   = 1
        return res;N
ctct=-1];
      sort(begicnted(cnt));
        sort(begin(n), nums
        long_long anck();
ctctans+=(longlogumsct
        int N =anuan.e(      0 ;      cnt[r[0]]++;
    }
};