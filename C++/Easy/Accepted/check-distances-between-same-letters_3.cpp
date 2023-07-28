class Solution {
public:
    bool checkDistances(string s, vector<int>& distance) {
        
        int n = s.size();
        int a[26] = {0};
        for(int i = 0; i < n; i++){
            a[s[i] - 'a']++;
        }
        for(int i = 0; i < 26; i++){
            if(a[i] != 0){
                int k = 0;
                for(int j = 0; j < n; j++){
                    if(s[j] == (char)(i + 'a')){
                        k++;
                        if(k == 2){
                            k = 0;
                            if(distance[i] != 0){
                                return false;
                            }
                        }
                    }
                    else{
                        if(k == 1){
                            distance[i]--;
                        }
                    }
                }
                if(distance[i] != 0){
                    return false;
                }
            }
        }
        return true;
    }
};