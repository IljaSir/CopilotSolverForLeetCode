class Solution {
public:
    string countOfAtoms(string formula) {
        
        int n = formula.size();
        stack<map<string, int>> st;
        st.push({});
        for (int i = 0; i < n; ++i) {
            if (formula[i] == '(') {
                st.push({});
            } else if (formula[i] == ')') {
                int iStart = ++i;
                while (i < n && isdigit(formula[i])) ++i;
                int mul = i > iStart ? stoi(formula.substr(iStart, i - iStart)) : 1;
                auto atom = st.top(); st.pop();
                for (auto& [name, cnt]: atom) {
                    st.top()[name] += cnt * mul;
                }
                --i;
            } else {
                int iStart = i++;
                while (i < n && islower(formula[i])) ++i;
                string name = formula.substr(iStart, i - iStart);
                iStart = i;
                while (i < n && isdigit(formula[i])) ++i;
                int cnt = i > iStart ? stoi(formula.substr(iStart, i - iStart)) : 1;
                st.top()[name] += cnt;
                --i;
            }
        }
        string ans;
        for (auto& [name, cnt]: st.top()) {
            ans += name;
            if (cnt > 1) ans += to_string(cnt);
        }
        return ans;
    }
};