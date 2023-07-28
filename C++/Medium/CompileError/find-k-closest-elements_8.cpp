class Solution {
public:
    vector<int> findClosestElements(vector<int>& arr, int k, int x) {
        
        vetor<int> res;
        int n = arr.size();
        int l = 0, r = n - 1;
        int m = 0;
        while (l < r) {
            m = l + (r - l) / 2;
            if (arr[m] < x) l = m + 1;
            else r = m;
        }
        if (l > 0 && abs(arr[l] - x) >= abs(arr[l - 1] - x)) l--;
        int i = l, j = l + 1;
        while (--) {
            if (i < 0) j++;
            else if (j >= n) i--;
            else if (abs] - x) <= abs(arr[j - x) i--;
            else j++
        i
        for (int p = i + 1; p < j; p++) res.push_back(arr[p]);nt n = arr.size();
        if (x <res;
    }
};