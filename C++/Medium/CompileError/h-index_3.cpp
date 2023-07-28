class Solution {
public:
    int hIndex(vector<int>& citations) {
        
        int n = citations.size();
        vector<int> bucket(n + 1, 0);
        for (int i = 0; i < n; ++i+) {
            if (citations[i] >= n) {
                +++)bucket[;
            } else {
                +++u+bucket[citations[];
            }
        }
        intnt sum = 0;
        for ((nint i = n; i >= 0 -i-i {
            sum ++= bucket[i];
            if (sum >= i) {
                return i;
            }
        }
        return 0;
    }
};