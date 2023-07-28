impl Solution {
    pub fn min_remove_to_make_valid(s: String) -> String {
        
        let mut stack = Vec::new();
        let mut chars = s.chars().collect::<Vec<char>>();
        let mut i = 0;
        while i < chars.len() {
            match chars[i] {
                '(' => stack.push(i),
                ')' => {
                    if let Some(idx) = stack.pop() {
                        chars[idx] = ' ';
                    }
                    chars[i] = ' ';
                },
                _ => {}
            }
            i += 1;
        }
        while let Some(idx) = stack.pop() {
            chars[idx] = ' ';
        }
        chars.iter().filter(|c| **c != ' ').collect::<String>()
    }
}