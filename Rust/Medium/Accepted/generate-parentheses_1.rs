impl Solution {
    pub fn generate_parenthesis(n: i32) -> Vec<String> {
        

        let mut ans = vec![];
        Self::backtrack(&mut ans, String::new(), 0, 0, n);
        ans
    }

    fn backtrack(ans: &mut Vec<String>, cur: String, open: i32, close: i32, max: i32) {
        if cur.len() == max as usize * 2 {
            ans.push(cur);
            return;
        }
        if open < max {
            Self::backtrack(ans, cur.clone() + "(", open + 1, close, max);
        }
        if close < open {
            Self::backtrack(ans, cur.clone() + ")", open, close + 1, max);
        }
    }
}