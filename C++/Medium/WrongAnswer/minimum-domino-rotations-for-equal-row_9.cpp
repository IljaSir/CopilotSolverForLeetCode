class Solution {
public:
    int minDominoRotations(vector<int>& tops, vector<int>& bottoms) {
        
        int n = tops.size();
        int top = tops[0], bottom = bottoms[0], top_count = 0, bottom_count = 0;
        for (int i = 0; i < n; ++i) {
            if (tops[i] != top && bottoms[i] != top) {
                top = -1;
            }
            if (tops[i] != bottom && bottoms[i] != bottom) {
                bottom = -1;
            }
            if (top == -1 && bottom == -1) {
                return -1;
            }
        }
        if (top == -1) {
            return count_rotations(bottoms, bottom);
        }
        if (bottom == -1) {
            return count_rotations(tops, top);
        }
        return min(count_rotations(tops, top), count_rotations(bottoms, bottom));
    }
    int count_rotations(vector<int>& arr, int target) {
        int n = arr.size(), count = 0;
        for (int i = 0; i < n; ++i) {
            if (arr[i] != target) {
                ++count;
            }
        }
        return count;
    }
};