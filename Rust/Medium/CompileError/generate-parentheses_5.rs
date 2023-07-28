impl Solution {
    pub fn generate_parenthesis(n: i32) -> Vec<String> {
        

        let mut res = vec![];
        Self::backtrack(n, 0, 0, String::new(), &mut res);
        res
    }

    fn backtrack(n: i32, open: i32, close: i32, s: String, res: &mut Vec<String>) {
        if s.len() == (n * 2) as usize {
            res.push(s);
            return;
        }

        if open < n {
            Self::backtrack(n, open + 1, close, s + "(", res);
        }

        if close < open {
            Self::backtrack(n, open, close + 1, s + ")", res);
        }
    }
}