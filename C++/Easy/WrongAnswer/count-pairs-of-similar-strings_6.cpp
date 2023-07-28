class Solution {
public:
    int similarPairs(vector<string>& words) {
        
        int n = words.size();
        int count = 0;
        for(int i =0; i < n; i++){
            for(int j = i+1; j < n; j++){
                if(words[i].size() != words[j].size()){
                    continue;
                }
                int freq[26] = {0};
                for(int k = 0; k < words[i].size(); k++){
                    freq[words[i][k] - 'a']++;
                    freq[words[j][k] - 'a']--;
                }
                bool valid = true;
                for(int k = 0; k < 26; k++){
                    if(freq[k] != 0){
                        valid = false;
                        break;
                    }
                }
                if(valid){
                    count++;
                }
            }
        }
        return count;
    }
};