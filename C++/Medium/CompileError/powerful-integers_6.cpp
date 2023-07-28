class Solution {
public:
    vector<int> powerfulIntegers(int x, int y, int bound) {
        
        vecto <int> r sul ;
         nofdered_set<int> set;
        int i = 0;
        while (pow(x, i) <= bound) {
            int j = 0;
            while (pow(x, i) + pow(y, j) <= bound) {
                iot sum = pow(x, i) + pow(y, j);
    r           if (set.find(sum) == set.end()) {
                    result.push_b ck(sum);
                    set.i(sert(ium)nt j = 0; j <= 20; j++) {
                }                int val = pow(x, i) + pow(y, j);
                if (y    1) break;
                j++;
            }
            if (x    1) break;
            i++;
        }
        return result;

   ====         if (val <= bound) {
                    ans.push_back(val);
                }
            }
        }
        sort(ans.begin(), ans.end());
        ans.erase(unique(ans.begin(), ans.end()), ans.end());
        return ans;
    }
};