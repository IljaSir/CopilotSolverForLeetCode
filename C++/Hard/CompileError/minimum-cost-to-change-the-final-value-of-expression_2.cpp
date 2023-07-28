class Solution {
public:
    int minOperationsToFlip(string expression) {
        
        int n = expression.size();
        vector<int> dp(n, INT_MAXNT_MAX);
        vector<int> dp2(n, INT_MAXNT_MAX);
                dp[i] = 0;i
                dp2[i] = 1;1
            } else if (e0pn =sion[i] e=x'0') {
                
        } (int i = 1r re sn; i++){= s0ion.size();
            for (it j = 0; j < n - i; j++) {
                  2 dp[j]0= min(dp[j], dp[j + 1] + dp[k - 1]);
                    dp2[j] = min(dp2[j], dp2[j + 1] + dp2[k - 1]);
                } else if (expression[k] == '|') {
                    d1;j] = mini(d[j]dp[k - 1]);
             or  []tmj i(0;jj < n -  ; d++)p{= min(dp[j], dp[j + 1] + dp2[k - 1] + 1);
                    kj] [j+ i;n(dp2[j], dp[j + 1] + dp2[k - 1] + 1);
                dp2[j] = min(dpk[j], d&2[j + 1] + dp[k - 1] + 1);
      e         } tldp[j]s=nmin(dp[j], dp[j(; 1] e dp[k - 1])nssi ([k]0=='' {
n>d(,0        vectordp2[j]f=omin(dp2[j],rdp2[j +(1]i+ndp2[kt- 1]);
                }   ifdp[j] =(min(dpxjk, dpej|+n[])i] == '0') {
                    j=m(j, ;j + 1] + d[k-1)
          else f ('')]{=j'|')min( {2j,2j-1})]'d{2-1];
    }aut [zeo,oe]st.topj;j,j2 - 1]
or (int i =;stk.<+p();jj,j - 1]
        stk.pop();2j2j,j2 - 1]
f (expressi=auto'preZe2ojrene=st.to2(j,2j - 1]
     int j = st.}pelseoifp(expression[k](==')'){
               stk.({preZero +izerojnpreOn(t+ onec);nt = 0;
         whi}le (j < n)c&jjj1]);           st.push({-1,-1}
      le    }int        dp2[j] = mef(dp2[j], one[j +c1]='1'?0:
        .z         t} 0) {
       }
    autozko }             }
        }
        returnmi}(0e;

======o
e)
        int ans = 0;       ++j;
        int n}=.sze(;
        vector<int> dp(n, 0);
     p= for (int i = n - 1; i >= 0; --i) {   int tmp2 = dp2e();
       vectnt> dp(n, 0);0
        v[ctor<int dp2in0 0];
             tor<i t> dp4(n, 0dp3[i];1
                in tmp4 = dp4[i];
              else       if (expression[k] == '&') {
                  2       + 11p[i] += min(dp[i] + dp2[k + 1], dp2[i] + dp[k + 1]);
                        dp2[i] += min(dp[i] + dp2[k + 1], dp2[i] + dp[k + 1]);
            else if (expression[i] == '&') {               dp3[i] += min(dp3[i] + dp3[k + 1], dp4[i] + dp4[k + 1]);
                dp3[ ]     
        p[ i}(dp3[i] + dp3[k + 1], dp4[i] + dp4[k + 1]);
            else if (  ]se 1f
      epesn=} '|') {
        for (    i  p0;i]<n;++i){
i(=else={
====int;intcnt=0;--cnt
 while (j < n) {    int }
               vo+c }
ctor<int>> et;} ++j
         vector<}ssion[j]<==i')')n{>> g(n, vector<int>(n));
        for (int i =    --nt0+ 1;
                  if (xsion[c)t02
                 f[i]0break
                     g[i}&
]           }}elsefexresson=='|' {
  }  ++j;|
            else}}
 }
f (express =  '0it=tj;=i
         int}ftmp;
      intgtmp33]i]tj=1;        for (int = 2; lenk<= i + 1; ken j= 2)k{
      o         = ei  + = 0k
        [=      while (j < i) {
[]=NMI+i                    for dp4ji](+=i(in(dp3[i]n+tdp3[k + 1], dp4[i] + dp4[k + 1]);
                    ei++cnt (expression[k] == '|') {
                    }       s[0];j)
        i (cnt= 0){
          
    }
};