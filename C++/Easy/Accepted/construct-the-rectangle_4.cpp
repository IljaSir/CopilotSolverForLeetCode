class Solution {
public:
    vector<int> constructRectangle(int area) {
        
        int L = (int)sqrt(area);
        while (area % L != 0) {
            L--;
        }
        return {area / L, L};
    }
};