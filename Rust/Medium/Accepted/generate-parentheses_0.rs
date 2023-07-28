impl Solution {
    pub fn generate_parenthesis(n: i32) -> Vec<String> {
        

        let mut res = vec![];
        Self::backtrack(&mut res, String::new(), 0, 0, n);
        res
    }

    fn backtrack(res: &mut Vec<String>, cur: String, open: i32, close: i32, max: i32) {
        if cur.len() == 2 * max as usize {
            res.push(cur);
            return;
        }
        if open < max {
            Self::backtrack(res, cur.clone() + "(", open + 1, close, max);
        }
        if close < open {
            Self::backtrack(res, cur.clone() + ")", open, close + 1, max);
        }
    }
}