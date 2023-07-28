class Solution {
public:
    long long distinctNames(vector<string>& ideas) {
        
        long long ans = 0;
        for(int i=0;i<ideas.size();i++){
            for(int j=i+1;j<ideas.size();j++){
                string idea1 = ideas[i];
                string idea2 = ideas[j];
                int n = idea1.size();
                int m = idea2.size();
                char temp = idea1[0];
                idea1[0] = idea2[0];
                idea2[0] = temp;
                if(find(ideas.begin(),ideas.end(),idea1) == ideas.end() && find(ideas.begin(),ideas.end(),idea2) == ideas.end()){
                    ans++;
                }
            }
        }
        return ans;
    }
};