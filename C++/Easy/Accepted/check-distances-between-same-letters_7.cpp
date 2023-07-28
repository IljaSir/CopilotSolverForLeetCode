class Solution {
public:
    bool checkDistances(string s, vector<int>& distance) {
        
        int n = s.size();
        for(int i=0;i<26;i++){
            int f = -1;
            for(int j=0;j<n;j++){
                if(s[j] == 'a'+i){
                    if(f == -1){
                        f = j;
                    }else{
                        if(j - f - 1 != distance[i]){
                            return false;
                        }
                        f = j;
                    }
                }
            }
        }
        return true;
    }
};