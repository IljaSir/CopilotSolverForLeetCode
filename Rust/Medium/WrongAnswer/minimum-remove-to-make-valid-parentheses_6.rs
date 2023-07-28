impl Solution {
    pub fn min_remove_to_make_valid(s: String) -> String {
        
        let mut stack = vec![];
        let mut res = vec![];
        for (i, c) in s.chars().enumerate() {
            if c == '(' {
                stack.push(i);
            } else if c == ')' {
                if let Some(j) = stack.pop() {
                    res.push((j, c));
                    res.push((i, c));
                }
            } else {
                res.push((i, c));
            }
        }
        res.sort_by_key(|(i, _)| *i);
        res.into_iter().map(|(_, c)| c).collect()
    }
}