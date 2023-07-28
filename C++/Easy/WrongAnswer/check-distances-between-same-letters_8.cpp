class Solution {
public:
    bool checkDistances(string s, vector<int>& distance) {
        
        int n = s.size();
        int x = 0;
        for(int i = 0; i < n; i++){
            if(s[i] == s[i+1]){
                if(distance[s[i] - 'a'] != i - x){
                    return false;
                }
                x = i + 1;
            }
        }
        return true;
    }
};