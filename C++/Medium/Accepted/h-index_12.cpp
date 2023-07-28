class Solution {
public:
    int hIndex(vector<int>& citations) {
        
        int n = citations.size();
        vector<int> count(n+1, 0);
        for (auto c : citations) {
            if (c >= n) {
                count[n]++;
            } else {
                count[c]++;
            }
        }
        int sum = 0;
        for (int i = n; i >= 0; i--) {
            sum += count[i];
            if (sum >= i) {
                return i;
            }
        }
        return 0;
    }
};