class Solution {
public:
    double calculateTax(vector<vector<int>>& brackets, int income) {
        
        double tax = 0;
        for (auto& bracket : brackets) {
            int upper = bracket[0];
            int percent = bracket[1];
            if (income > upper) {
                tax += upper * percent / 100.0;
                income -= upper;
            } else {
                tax += income * percent / 100.0;
                break;
            }
        }
        return tax;
    }
    double calculateTax2(vector<vector<int>>& brackets, int income) {
        double tax = 0;
        for (int i = 0; i < brackets.size(); ++i) {
            int upper = brackets[i][0];
            int percent = brackets[i][1];
            if (income > upper) {
                tax += upper * percent / 100.0;
                income -= upper;
            } else {
                tax += income * percent / 100.0;
                break;
            }
        }
        return tax;
    }
    double calculateTax3(vector<vector<int>>& brackets, int income) {
        double tax = 0;
        for (auto it = brackets.begin(); it != brackets.end(); ++it) {
            int upper = (*it)[0];
            int percent = (*it)[1];
            if (income > upper) {
                tax += upper * percent / 100.0;
                income -= upper;
            } else {
                tax += income * percent / 100.0;
                break;
            }
        }
        return tax;
    }
    double calculateTax4(vector<vector<int>>& brackets, int income) {
        double tax = 0;
        for (int i = 0, size = brackets.size(); i < size; ++i) {
            int upper = brackets[i][0];
            int percent = brackets[i][1];
            if (income > upper) {
                tax += upper * percent / 100.0;
                income -= upper;
            } else {
                tax += income * percent / 100.0;
                break;
            }
        }
        return tax;
    }
};