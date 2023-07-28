class Solution {
public:
    int calPoints(vector<string>& operations) {
        
        int sum=0;
        vector<int> scores;
        for(int i=0;i<operations.size();i++){
            if(operations[i]=="C"){
                sum-=scores[scores.size()-1];
                scores.pop_back();
            }
            else if(operations[i]=="D"){
                scores.push_back(2*scores[scores.size()-1]);
                sum+=scores[scores.size()-1];
            }
            else if(operations[i]=="+"){
                scores.push_back(scores[scores.size()-1]+scores[scores.size()-2]);
                sum+=scores[scores.size()-1];
            }
            else{
                scores.push_back(stoi(operations[i]));
                sum+=scores[scores.size()-1];
            }
        }
        return sum;
    }
};