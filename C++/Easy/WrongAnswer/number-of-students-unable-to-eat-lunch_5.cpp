class Solution {
public:
    int countStudents(vector<int>& students, vector<int>& sandwiches) {
        
        int c1 = 0;
        int c2 = 0;
        for(int i=0; i<students.size(); i++){
            if(students[i] == 0) c1++;
            else c2++;
        }
        int i = 0;
        while(i<sandwiches.size() && c1 != 0 && c2 != 0){
            if(sandwiches[i] == 0 && c1 != 0){
                c1--;
                i++;
            }else if(sandwiches[i] == 1 && c2 != 0){
                c2--;
                i++;
            }else{
                break;
            }
        }
        return c1 + c2;
    }
};