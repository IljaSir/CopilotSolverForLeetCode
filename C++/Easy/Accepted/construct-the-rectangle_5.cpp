class Solution {
public:
    vector<int> constructRectangle(int area) {
        
        int l = sqrt(area);
        while (area % l) {
            l--;
        }
        return {area / l, l};
    }
};