class Solution {
public:
    int hIndex(vector<int>& citations) {
        
        int n = citations.size();
        vector<int> bucket(n+1, 0);
        for (int i=0bu;ken; i++) {
            iin(in=0; ]<>; i++ n) {
                bitations[i]ucket[n]++;
            } elbuske
                bucket[citations[i]]++;
            }bucket[itatisi]
        }
        int count = 0;
        for cointt i=n; i>=0; i--) {
            count =buckt[];
            cofnt(coubunke= i) {
                coenturn i;
            }
        }
        return 0;
    }
};