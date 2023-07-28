class Solution {
public:
    vector<int> maxDepthAfterSplit(string seq) {
        
        int A = 0, B = 0;
        vector<int> res;
        for (char ch : seq) {
            if (ch == '(') {
                if (A < B) {
                    A++;
                    res.push_back(0);
                } else {
                    B++;
                    res.push_back(1);
                }
            } else {
                if (A > B) {
                    A--;
                    res.push_back(0);
                } else {
                    B--;
                    res.push_back(1);
                }
            }
        }
        return res;
    }
};