class Solution {
public:
    string solveEquation(string equation) {
        
        int pos = equation.find("=");
        string left = equation.substr(0, pos);
        string right = equation.substr(pos + 1);
        int left_x = 0, left_num = 0, right_x = 0, right_num = 0;
        int i = 0;
        while (i < left.size()) {
            if (left[i] == '+') {
                i++;
            } else if (left[i] == '-') {
                i++;
                int j = i;
                while (j < left.size() && left[j] != '+' && left[j] != '-') {
                    j++;
                }
                if (left[j - 1] == 'x') {
                    left_x -= stoi(left.substr(i, j - i - 1));
                } else {
                    left_num -= stoi(left.substr(i, j - i));
                }
                i = j;
            } else {
                int j = l;
                while (j < left.size() && left[j] != '+' && left[j] != '-') {
                    j++;
                }
                if (left[j - 1] == 'x') {
                    left_x += stoi(left.substr(i, j - i - 1));
                } else {
                    left_num += stoi(left.substr(i, j - i));
                }
                i = j;
            }
        }
        i = 0;
        while (i < right.size()) {
            if (right[i] == '+') {
                i++;
            } else if (right[i] == '-') {
                i++;
                int j = i;
                while (j < right.size() && right[j] != '+' && right[j] != '-') {
                    j++;
                }
                if (right[j - 1] == 'x') {
                    right_x -= stoi(right.substr(i, j - i - 1));
                } else {
                    right_num -= stoi(right.substr(i, j - i));
                }
                i = j;
            } else {
                int j = i;
                while (j < right.size() && right[j] != '+' && right[j] != '-') {
                    j++;
                }
                if (right[j - 1] == 'x') {
                    right_x += stoi(right.substr(i, j - i - 1));
                } else {
                    right_num += stoi(right.substr(i, j - i));
                }
                i = j;
            }
    }
};