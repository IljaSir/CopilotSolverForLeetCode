class Solution {
public:
    vector<int> constructRectangle(int area) {
        
        vector<int> res;
        int i = sqrt(area);
        while (i > 0) {
            if (area % i == 0) {
                res.push_back(area / i);
                res.push_back(i);
                break;
            }
            i--;
        }
        return res;
    }
};