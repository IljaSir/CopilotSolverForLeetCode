class Solution {
public:
    vector<int> sequentialDigits(int low, int high) {
        
        vector<int> res;
        int n = to_string(low).length();
        int m = to_string(high).length();
        for(int i = n; i <= m; i++) {
            for(int j = 1; j <= 10-i; j++) {
                int tmp = 0;
                for(int k = j; k < j+i; k++) {
                    tmp = tmp * 10 + k;
                }
                if(tmp >= low && tmp <= high) {
                    res.push_back(tmp);
                }
            }
        }
        return res;
    }
};