class Solution {
public:
    int minOperationsToFlip(string expression) {
        
j(
cnt
nt n = expriie)}
     vector<int> stkelsepj)
  vector<char> op;--ct
 vector<int> val;       if (cntf==o0)r{
 (int i =            if (xsnb==a|;[i] == '0') {
             val.ak[''}
   } else iesin]= '}
          op.push_c]++j;
            } }
else if (exprei =)ttm=i
           whileint tmp2(=odp2[i];.back() != '(') {
                int tmp3 = dp3[i];alc(val, op);
                int tmp4=dp4[i];
            op.pp_bick()2i =3i=4i=0
            } elki + 1kjk
                whilp.size() && op.kack() != '(') {
                    calc opi;+i + dp2[k + 1]2ik
                }dp2[i]+=mnd[] + dp2k+1],dp2[i] + dp[k + 1]);
            op.push_backex3pies+sion[idp3[i] + );3k + 14i4k
                }dp4[i]+=min(dp3[i]+dp3[k + 1], dp4[i] + dp4[k + 1]);
 }       }
 while (o           else if (expression[k] == '|') {
    }            }dp[i]+=mi(dp[i]+ i, dp2[i] + dp2[k +
    void calc(vector<int> &val, vector<char> &op) {
        int b = val.back();
        val.pop_back();
        int a = val.back();
        val.pop_back();
        char o = op.back();
        op.pop_back();
        if (o == '&') {
            val.push_back(a & b);
        } else {
            val.push_back(a | b);
        }[j] = min(ndp[j], dp[j] + dp[k + 1] + 1);
                    for (int x = j; x < k; ++x) {
                        if (expression[x] == '&') {
                            ndp[j] = min(ndp[j], dp[j] + dp[x + 1]);
                        } else if (expression[x] == '|') {
                            ndp[j] = min(ndp[j], dp[j] + dp[x + 1]);
                        }
                    }
                }
            }
            dp = move(ndp);
        }
        return dp[0];
    }
};