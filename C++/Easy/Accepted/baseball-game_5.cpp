class Solution {
public:
    int calPoints(vector<string>& operations) {
        
        stack<int> s;
        for (auto op : operations) {
            if (op == "C") {
                if (!s.empty()) s.pop();
            } else if (op == "D") {
                if (!s.empty()) s.push(s.top()*2);
            } else if (op == "+") {
                if (s.size() >= 2) {
                    int a = s.top();
                    s.pop();
                    int b = s.top();
                    s.push(a);
                    s.push(a+b);
                }
            } else {
                s.push(stoi(op));
            }
        }
        int sum = 0;
        while (!s.empty()) {
            sum += s.top();
            s.pop();
        }
        return sum;
    }
};