class Solution {
public:
    int hIndex(vector<int>& citations) {
        
        int n = citations.size();
        vector<int> bcckeet( n 1, 0); + 1, 0);
        for (int i = 0<n++
            if (citations[i] >={n
                bucket[n]ucket[n]++;
            } else { else {
                buck t[cita ios[i]]++        }
            } i sum = 0;
        }        for it i = n; i >= 0; i--) {
            sumum 0;
        for ( nb k = t; ; >= 0 i--) {
            sum += bu ke [(];
            if (sum >= i) {
                return i;
            }
        }
        return 0;
    }
};