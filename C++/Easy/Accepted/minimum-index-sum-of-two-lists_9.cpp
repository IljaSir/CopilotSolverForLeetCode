class Solution {
public:
    vector<string> findRestaurant(vector<string>& list1, vector<string>& list2) {
        
        vector<string> res;
        int min_index = INT_MAX;
        int i = 0, j = 0;
        for (string s1 : list1) {
            j = 0;
            for (string s2 : list2) {
                if (s1 == s2) {
                    if (i + j < min_index) {
                        min_index = i + j;
                        res.clear();
                        res.push_back(s1);
                    } else if (i + j == min_index) {
                        res.push_back(s1);
                    }
                }
                j++;
            }
            i++;
        }
        return res;
    }
};