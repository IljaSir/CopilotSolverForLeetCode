class Solution {
public:
    int kthSmallest(vector<vector<int>>& matrix, int k) {
        
        int n = matrix.size();
        int l = matrix[0][0], r = matrix[n-1][n-1];
        while(l < r) {
            int mid = l + (r-l)/2;
            if(count(matrix, mid) < k) l = mid + 1;
            else r = mid;
        }
        return l;
    }
    int count(vector<vector<int>>& matrix, int mid) {
        int i = matrix.size()-1, j = 0, res = 0;
        while(i >= 0 && j < matrix.size()) {
            if(matrix[i][j] <= mid) {
                res += i+1;
                j++;
            }
            else i--;
        }
        return res;
    }
};