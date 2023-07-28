class Solution {
public:
    bool threeConsecutiveOdds(vector<int>& arr) {
        
        int n = arr.size();
        if (n < 3) return false;
        int i = 0, j = 0;
        while (j < n) {
            while (j < n && arr[j] % 2 == 0) j++;
            if (j - i == 3) return true;
            i = j;
            j++;
        }
        return false;
    }
};