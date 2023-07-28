impl Solution {
    pub fn min_remove_to_make_valid(s: String) -> String {
        
        let mut stack: Vec<usize> = vec![];
        let mut res: Vec<char> = vec![];
        for (i, c) in s.chars().enumerate() {
            if c == '(' {
                stack.push(i);
            } else if c == ')' {
                if let Some(j) = stack.pop() {
                    res[j] = '(';
                    res.push(')');
                }
            } else {
                res.push(c);
            }
        }
        res.into_iter().filter(|c| *c != '(').collect()
    }
}