class Solution {
public:
    int findLucky(vector<int>& arr) {
        
        int max = -1;
        int n = arr.size();
        int count[n+1];
        memset(count, 0, sizeof(count));
        for(int i = 0; i < n; i++) {
            count[arr[i]]++;
        }
        for(int i = 1; i <= n; i++) {
            if(count[i] == i) {
                max = i;
            }
        }
        return max;
    }
};