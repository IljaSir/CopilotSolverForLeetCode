impl Solution {
    pub fn generate_parenthesis(n: i32) -> Vec<String> {
        

        let mut res = vec![];
        Self::dfs(0, 0, n, &mut String::new(), &mut res);
        res
    }

    fn dfs(left: i32, right: i32, n: i32, s: &mut String, res: &mut Vec<String>) {
        if left == n && right == n {
            res.push(s.clone());
            return;
        }
        if left < n {
            s.push('(');
            Self::dfs(left + 1, right, n, s, res);
            s.pop();
        }
        if right < left {
            s.push(')');
            Self::dfs(left, right + 1, n, s, res);
            s.pop();
        }
    }
}