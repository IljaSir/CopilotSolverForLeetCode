class Solution {
public:
    bool threeConsecutiveOdds(vector<int>& arr) {
        
        int n = arr.size();
        if (n < 3) return false;
        int i = 0;
        for (i = 0; i < n-2; i++) {
            if (arr[i] % 2 == 0) continue;
            if (arr[i+1] % 2 == 0) continue;
            if (arr[i+2] % 2 == 0) continue;
            return true;
        }
        return false;
    }
};