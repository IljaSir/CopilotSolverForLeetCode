impl Solution {
    pub fn generate_parenthesis(n: i32) -> Vec<String> {
        

        let mut ans = Vec::new();
        Self::gen(&mut ans, 0, 0, n, String::new());
        ans
    }
    fn gen(ans: &mut Vec<String>, open: i32, close: i32, n: i32, s: String) {
        if s.len() == 2 * n as usize {
            ans.push(s);
            return;
        }
        if open < n {
            Self::gen(ans, open + 1, close, n, s + "(");
        }
        if close < open {
            Self::gen(ans, open, close + 1, n, s + ")");
        }
    }
}