class Solution {
public:
    double average(vector<int>& salary) {
        
        int min = salary[0];
        int max = salary[0];
        int sum = 0;
        for (int s: salary) {
            sum += s;
            if (s < min)
                min = s;
            if (s > max)
                max = s;
        }
        return (double)(sum - min - max) / (salary.size() - 2);
    }
};