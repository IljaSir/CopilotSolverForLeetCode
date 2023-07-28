class Solution {
public:
    int eatenApples(vector<int>& apples, vector<int>& days) {
        
        map<int, int> mp;
        int res = 0;
        int n = apples.size();
        for (int i = 0; i < n; i++) {
            if (apples[i] > 0) {
                mp[i + days[i]] += apples[i];
            }
            if (mp.size() > 0) {
                auto it = mp.begin();
                it->second--;
                if (it->second == 0) {
                    mp.erase(it);
                }
                res++;
            }
        }
        int i = n;
        while (mp.size() > 0) {
            auto it = mp.begin();
            if (it->first <= i) {
                mp.erase(it);
                continue;
            }
            int cnt = min(it->second, it->first - i);
            res += cnt;
            it->second -= cnt;
            i += cnt;
        }
        return res;
    }
};