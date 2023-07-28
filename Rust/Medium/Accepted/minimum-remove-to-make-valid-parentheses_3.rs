impl Solution {
    pub fn min_remove_to_make_valid(s: String) -> String {
        
        let mut stack = vec![];
        let mut remove = vec![false; s.len()];
        for (i, c) in s.chars().enumerate() {
            if c == '(' {
                stack.push(i);
            } else if c == ')' {
                if let Some(j) = stack.pop() {
                    remove[j] = false;
                } else {
                    remove[i] = true;
                }
            }
        }
        for i in stack {
            remove[i] = true;
        }
        s.chars()
            .enumerate()
            .filter(|(i, _)| !remove[*i])
            .map(|(_, c)| c)
            .collect()
    }
}