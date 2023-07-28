class Solution {
public:
    double calculateTax(vector<vector<int>>& brackets, int income) {
        
        double tax = 0;
        for (int i = 0; i < brackets.size(); i++) {
            if (income > brackets[i][0]) {
                tax += brackets[i][0] * brackets[i][1] / 100;
                income -= brackets[i][0];
            } else {
                tax += income * brackets[i][1] / 100;
                break;
            }
        }
        return tax;
    }
    double calculateTax2(vector<vector<int>>& brackets, int income) {
        double tax = 0;
        for (int i = 0; i < brackets.size(); i++) {
            if (income > brackets[i][0]) {
                tax += brackets[i][0] * brackets[i][1] / 100;
                income -= brackets[i][0];
            } else {
                tax += income * brackets[i][1] / 100;
                break;
            }
        }
        return tax;
    }
    double calculateTax3(vector<vector<int>>& brackets, int income) {
        double tax = 0;
        for (int i = 0; i < brackets.size(); i++) {
            if (income > brackets[i][0]) {
                tax += brackets[i][0] * brackets[i][1] / 100;
                income -= brackets[i][0];
            } else {
                tax += income * brackets[i][1] / 100;
                break;
            }
        }
        return tax;
    }
    double calculateTax4(vector<vector<int>>& brackets, int income) {
        double tax = 0;
        for (int i = 0; i < brackets.size(); i++) {
            if (income > brackets[i][0]) {
                tax += brackets[i][0] * brackets[i][1] / 100;
                income -= brackets[i][0];
            } else {
                tax += income * brackets[i][1] / 100;
                break;
            }
        }
        return tax;
    }
};