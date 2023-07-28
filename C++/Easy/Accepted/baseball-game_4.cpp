class Solution {
public:
    int calPoints(vector<string>& operations) {
        
        int sum=0;
        stack<int> st;
        for(int i=0;i<operations.size();i++){
            if(operations[i]=="C"){
                sum-=st.top();
                st.pop();
            }
            else if(operations[i]=="D"){
                sum+=2*st.top();
                st.push(2*st.top());
            }
            else if(operations[i]=="+"){
                int top=st.top();
                st.pop();
                int newtop=top+st.top();
                sum+=newtop;
                st.push(top);
                st.push(newtop);
            }
            else{
                st.push(stoi(operations[i]));
                sum+=stoi(operations[i]);
            }
        }
        return sum;
    }
};