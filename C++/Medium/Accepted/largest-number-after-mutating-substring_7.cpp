class Solution {
public:
    string maximumNumber(string num, vector<int>& change) {
        
        int n = num.size();
        int start = -1;
        for(int i = 0; i < n; i++) {
            int d = num[i] - '0';
            if(change[d] > d) {
                start = i;
                break;
            }
        }
        if(start == -1) return num;
        for(int i = start; i < n; i++) {
            int d = num[i] - '0';
            if(change[d] >= d) {
                num[i] = change[d] + '0';
            }
            else break;
        }
        return num;
    }
};