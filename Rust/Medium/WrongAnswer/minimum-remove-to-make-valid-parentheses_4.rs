impl Solution {
    pub fn min_remove_to_make_valid(s: String) -> String {
        
        let mut stack = Vec::new();
        let mut chars = s.chars().collect::<Vec<char>>();
        for i in 0..chars.len() {
            match chars[i] {
                '(' => {
                    stack.push(i);
                }
                ')' => {
                    if let Some(idx) = stack.pop() {
                        chars[idx] = ' ';
                    } else {
                        chars[i] = ' ';
                    }
                }
                _ => {}
            }
        }
        for i in stack {
            chars[i] = ' ';
        }
        chars.into_iter().filter(|c| *c != ' ').collect()
    }
}