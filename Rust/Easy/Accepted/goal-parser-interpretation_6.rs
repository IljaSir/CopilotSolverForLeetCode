impl Solution {
    pub fn interpret(command: String) -> String {
        
        let mut res = String::new();
        let mut chars = command.chars();
        while let Some(c) = chars.next() {
            match c {
                'G' => res.push('G'),
                '(' => {
                    match chars.next() {
                        Some('a') => res.push_str("al"),
                        Some(')') => res.push('o'),
                        _ => (),
                    }
                }
                _ => (),
            }
        }
        res
    }
}