class Solution {
public:
    double average(vector<int>& salary) {
        
        int sum = 0;
        int min = INT_MAX;
        int max = INT_MIN;
        for(int i = 0; i < salary.size(); i++) {
            sum += salary[i];
            if(salary[i] < min) min = salary[i];
            if(salary[i] > max) max = salary[i];
        }
        return (double)(sum - min - max) / (salary.size() - 2);
    }
};