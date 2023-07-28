class Solution {
public:
    bool validMountainArray(vector<int>& arr) {
        
        if (arr.size() < 3) return false;
        bool up = true;
        for (int i = 1; i < arr.size(); i++) {
            if (arr[i] > arr[i-1]) {
                if (!up) return false;
            } else if (arr[i] < arr[i-1]) {
                if (i == 1) return false;
                up = false;
            } else {
                return false;
            }
        }
        return !up;
    }
};