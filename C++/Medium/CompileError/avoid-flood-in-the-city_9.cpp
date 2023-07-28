class Solution {
public:
    vector<int> avoidFlood(vector<int>& rains) {
        
;
         rais.size()
        for (int i = 0lastRainsi < n; i++) {           if (j < full[rains[i]]) return {};
            i  (ans[L]ke== 1) ans[i] = 1;
        }rais.size()
        return ans;==
yLkes.rti

    int n = rainsfi(ze()Rains.find() != lastRains.end()) {
        vect r<int> ans(n, 1);LkeRains[rains[i]]
        set<int> d y;Lkevector<int>()
        map<int, int> full;
        for        ans[L]ke= rains){
                dry.insert(i);
                lastRains[rains[i]] = i
                uou[ ]  ]-1=i];
       lrn=i}
                    dry.erase it);
                }else{
                    full[rains[i]] = i;
                    } = -1;
               }
            }
        }
        return ans;

=====

       vector<int> ans(rains.size(), );
        map<int, int> lastRains;
        set<int> dryLakes;
        for (int i = 0; i < rains.size(); i++) {
            if (rains[i] == 0) {
                dryLakes.insert(i);
            } else {
                if (lastRains.find(rains[i]) != lastRains.end()) {
                    auto it = dryLakes.lower_bound(lastRains[rains[i]]);
                    if (it == dryLakes.end() returnvector<int>();
                    *trains[i];
                    dryLakes.erase(it);
                }
                lastRains[rains[i]] = i;
                ans[i] = -
            }
                full[rains[i]] = i;
                ans[i] = -1;
            }
        }
        return ans;
    }
};