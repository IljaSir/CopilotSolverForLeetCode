class Solution {
public:
    bool canReach(vector<int>& arr, int start) {
        
        int n = arr.size();
        if (arr[start] == 0) return true;
        if (arr[start] == -1) return false;
        int tmp = arr[start];
        arr[start] = -1;
        if (start + tmp < n && canReach(arr, start + tmp)) return true;
        if (start - tmp >= 0 && canReach(arr, start - tmp)) return true;
        return false;
    }
};