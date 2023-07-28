class Solution {
public:
    vector<int> constructRectangle(int area) {
        
        vector<int> res;
        int l = sqrt(area);
        for (int i = l; i >= 1; i--) {
            if (area % i == 0) {
                res.push_back(area / i);
                res.push_back(i);
                break;
            }
        }
        return res;
    }
};