class Solution {
public:
    bool buddyStrings(string s, string goal) {
        
        if(s.length() != goal.length()) return false;
        if(s == goal){
            int arr[26] = {0};
            for(int i = 0; i < s.length(); i++){
                arr[s[i] - 'a']++;
            }
            for(int i = 0; i < 26; i++){
                if(arr[i] > 1) return true;
            }
            return false;
        }
        int first = -1;
        int second = -1;
        for(int i = 0; i < s.length(); i++){
            if(s[i] != goal[i]){
                if(first == -1){
                    first = i;
                }else if(second == -1){
                    second = i;
                }else{
                    return false;
                }
            }
        }
        if(first == -1 || second == -1) return false;
        return s[first] == goal[second] && s[second] == goal[first];
    }
};