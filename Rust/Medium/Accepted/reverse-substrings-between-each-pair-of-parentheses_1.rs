impl Solution {
    pub fn reverse_parentheses(s: String) -> String {
        
        let mut s = s.chars().collect::<Vec<_>>();
        let mut stack = Vec::new();
        for i in 0..s.len() {
            if s[i] == '(' {
                stack.push(i);
            } else if s[i] == ')' {
                let j = stack.pop().unwrap();
                s[j..i].reverse();
            }
        }
        s.into_iter().filter(|&c| c != '(' && c != ')').collect()
    }
}