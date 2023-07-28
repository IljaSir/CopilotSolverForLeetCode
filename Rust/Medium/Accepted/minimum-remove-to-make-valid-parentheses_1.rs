impl Solution {
    pub fn min_remove_to_make_valid(s: String) -> String {
        
        let mut s = s.chars().collect::<Vec<_>>();
        let mut stack = Vec::new();
        for i in 0..s.len() {
            if s[i] == '(' {
                stack.push(i);
            } else if s[i] == ')' {
                if let Some(_) = stack.pop() {
                    continue;
                } else {
                    s[i] = ' ';
                }
            }
        }
        while let Some(i) = stack.pop() {
            s[i] = ' ';
        }
        s.into_iter().filter(|&c| c != ' ').collect()
    }
}