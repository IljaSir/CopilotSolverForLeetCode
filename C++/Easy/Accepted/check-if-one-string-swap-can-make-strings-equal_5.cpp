class Solution {
public:
    bool areAlmostEqual(string s1, string s2) {
        
        int n = s1.size();
        int count = 0;
        for(int i = 0; i < n; i++){
            if(s1[i] != s2[i]){
                count++;
            }
        }
        if(count == 0){
            return true;
        }
        if(count == 2){
            sort(s1.begin(), s1.end());
            sort(s2.begin(), s2.end());
            for(int i = 0; i < n; i++){
                if(s1[i] != s2[i]){
                    return false;
                }
            }
            return true;
        }
        return false;
    }
};