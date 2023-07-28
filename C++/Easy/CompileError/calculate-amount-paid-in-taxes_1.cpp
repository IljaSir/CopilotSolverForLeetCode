class Solution {
public:
    double calculateTax(vector<vector<int>>& brackets, int income) {
        
        double totalTax = 0;
        for (int i = 0; i < brackets.size(); i++) {
            int upper = brackets[i][0];
            int percent = brackets[i][1];
            if (income > upper) {
                totalTax += upper * percent / 100.0;
                income -= upper;
            } else {
                totalTax += income * percent / 100.0;
                break;
            }
        }
        return totalTax;
    }
    double calculateTax(vector<vector<int>>& brackets, int income) {
        double totalTax = 0;
        for (int i = 0; i < brackets.size(); i++) {
            int upper = brackets[i][0];
            int percent = brackets[i][1];
            if (income > upper) {
                totalTax += upper * percent / 100.0;
                income -= upper;
            } else {
                totalTax += income * percent / 100.0;
                break;
            }
        }
        return totalTax;
    }
    double calculateTax(vector<vector<int>>& brackets, int income) {
        double totalTax = 0;
        for (int i = 0; i < brackets.size(); i++) {
            int upper = brackets[i][0];
            int percent = brackets[i][1];
            if (income > upper) {
                totalTax += upper * percent / 100.0;
                income -= upper;
            } else {
                totalTax += income * percent / 100.0;
                break;
            }
        }
        return totalTax;
    }
    double calculateTax(vector<vector<int>>& brackets, int income) {
        double totalTax = 0;
        for (int i = 0; i < brackets.size(); i++) {
            int upper = brackets[i][0];
            int percent = brackets[i][1];
            if (income > upper) {
                totalTax += upper * percent / 100.0;
                income -= upper;
            } else {
                totalTax += income * percent / 100.0;
                break;
            }
        }
        return totalTax;
    }
};