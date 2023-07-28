class Solution {
public:
    bool equationsPossible(vector<string>& equations) {
        
        vector<int> parent(26);
        for(int i=0;i<26;i++) parent[i]=i;
        for(string& s:equations){
            if(s[1]=='='){
                int x=s[0]-'a',y=s[3]-'a';
                parent[find(parent,x)]=find(parent,y);
            }
        }
        for(string& s:equations){
            if(s[1]=='!'){
                int x=s[0]-'a',y=s[3]-'a';
                if(find(parent,x)==find(parent,y)) return false;
            }
        }
        return true;
    }
};