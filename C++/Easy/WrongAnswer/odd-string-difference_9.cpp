class Solution {
public:
    string oddString(vector<string>& words) {
        
        vector<int> diff;
        for(int i=0;i<words.size();i++){
            diff = diffArray(words[i]);
            for(int j=0;j<words.size();j++){
                if(i==j) continue;
                if(diffArray(words[j])!=diff) return words[j];
            }
        }
        return "";
    }
    vector<int> diffArray(string word){
        vector<int> diff;
        for(int i=0;i<word.size()-1;i++){
            diff.push_back(word[i+1]-word[i]);
        }
        return diff;
    }
};