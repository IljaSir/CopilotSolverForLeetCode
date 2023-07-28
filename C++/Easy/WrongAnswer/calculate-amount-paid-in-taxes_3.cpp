class Solution {
public:
    double calculateTax(vector<vector<int>>& brackets, int income) {
        
        double tax = 0;
        for (auto& b : brackets) {
            int amount = min(income, b[0]);
            tax += amount * b[1] / 100.0;
            income -= amount;
        }
        return tax;
    }
    double calculateTax2(vector<vector<int>>& brackets, int income) {
        double tax = 0;
        for (int i = 0; i < brackets.size(); i++) {
            int amount = income;
            if (i < brackets.size() - 1)
                amount = min(amount, brackets[i + 1][0]);
            tax += amount * brackets[i][1] / 100.0;
            income -= amount;
        }
        return tax;
    }
    double calculateTax3(vector<vector<int>>& brackets, int income) {
        double tax = 0;
        for (int i = 0; i < brackets.size(); i++) {
            int amount = income;
            if (i < brackets.size() - 1)
                amount = min(amount, brackets[i + 1][0] - brackets[i][0]);
            tax += amount * brackets[i][1] / 100.0;
            income -= amount;
        }
        return tax;
    }
    double calculateTax4(vector<vector<int>>& brackets, int income) {
        double tax = 0;
        for (int i = 0; i < brackets.size(); i++) {
            int amount = income;
            if (i < brackets.size() - 1)
                amount = min(amount, brackets[i + 1][0] - brackets[i][0]);
            tax += amount * brackets[i][1] / 100.0;
            income -= amount;
            if (income == 0)
                break;
        }
        return tax;
    }
    double calculateTax5(vector<vector<int>>& brackets, int income) {
        double tax = 0;
        for (int i = 0; i < brackets.size(); i++) {
            int amount = income;
            if (i < brackets.size() - 1)
                amount = min(amount, brackets[i + 1][0] - brackets[i][0]);
            tax += amount * brackets[i][1] / 100.0;
            income -= amount;
            if (income <= 0)
                break;
        }
        return tax;
    }
};