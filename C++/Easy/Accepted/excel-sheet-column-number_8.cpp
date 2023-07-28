class Solution {
public:
    int titleToNumber(string columnTitle) {
        
        int n = columnTitle.length();
        int res = 0;
        for(int i = 0; i < n; i++){
            res = res * 26 + (columnTitle[i] - 'A' + 1);
        }
        return res;
    }
};