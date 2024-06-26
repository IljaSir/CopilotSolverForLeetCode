class Solution {
public:
    int calPoints(vector<string>& operations) {
        
        stack<int> s;
        for (auto& op : operations) {
            if (op == "C") {
                s.pop();
            } else if (op == "D") {
                s.push(s.top() * 2);
            } else if (op == "+") {
                int a = s.top(); s.pop();
                int b = s.top(); s.pop();
                s.push(b);
                s.push(a);
                s.push(a + b);
            } else {
                s.push(stoi(op));
            }
        }
        int ans = 0;
        while (!s.empty()) {
            ans += s.top();
            s.pop();
        }
        return ans;
    }
};