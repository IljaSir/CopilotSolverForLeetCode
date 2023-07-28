class Solution {
public:
    vector<int> constructRectangle(int area) {
        
        int l = sqrt(area);
        while (area%l != 0) --l;
        return {area/l, l};
    }
};