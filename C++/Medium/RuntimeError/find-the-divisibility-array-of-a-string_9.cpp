class Solution {
public:
    vector<int> divisibilityArray(string word, int m) {
        
        vector<int> result;
        int n = word.size();
        int current = 0;
        for(int i = 0; i < n; i++) {
            current = (current * 10 + (word[i] - '0')) % m;
            result.push_back(current == 0);
        }
        return result;
    }
};