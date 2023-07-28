class Solution {
public:
    vector<int> divisibilityArray(string word, int m) {
        
        vector<int> res;
        int n = word.size();
        int num = 0;
        for(int i = 0; i < n; i++){
            num = (num * 10 + word[i] - '0') % m;
            if(num % m == 0)
                res.push_back(1);
            else
                res.push_back(0);
        }
        return res;
    }
};