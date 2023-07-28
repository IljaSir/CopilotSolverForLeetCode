class Solution {
public:
    double average(vector<int>& salary) {
        
        int min = salary[0];
        int max = salary[0];
        double sum = 0;
        for (int i = 0; i < salary.size(); ++i) {
            if (salary[i] < min) {
                min = salary[i];
            }
            if (salary[i] > max) {
                max = salary[i];
            }
            sum += salary[i];
        }
        return (sum - min - max) / (salary.size() - 2);
    }
};