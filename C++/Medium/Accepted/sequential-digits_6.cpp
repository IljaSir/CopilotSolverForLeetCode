class Solution {
public:
    vector<int> sequentialDigits(int low, int high) {
        
        vector<int> res;
        int num = 123456789;
        for(int i = 1; i < 9; i++) {
            for(int j = 0; j < 9 - i; j++) {
                int n = (num / (int)pow(10, j)) % (int)pow(10, i + 1);
                if(n >= low && n <= high) res.push_back(n);
            }
        }
        sort(res.begin(), res.end());
        return res;
    }
};