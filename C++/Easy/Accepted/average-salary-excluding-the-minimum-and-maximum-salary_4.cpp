class Solution {
public:
    double average(vector<int>& salary) {
        
        int min = 1000000;
        int max = 0;
        int sum = 0;
        for (int i = 0; i < salary.size(); i++) {
            if (salary[i] < min) min = salary[i];
            if (salary[i] > max) max = salary[i];
            sum += salary[i];
        }
        return (sum - min - max) / 1.0 / (salary.size() - 2);
    }
};