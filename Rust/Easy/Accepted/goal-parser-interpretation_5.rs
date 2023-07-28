impl Solution {
    pub fn interpret(command: String) -> String {
        
        let mut result = String::new();
        let mut chars = command.chars();
        while let Some(c) = chars.next() {
            match c {
                'G' => result.push('G'),
                '(' => {
                    match chars.next() {
                        Some(')') => result.push('o'),
                        Some('a') => {
                            chars.next();
                            chars.next();
                            result.push_str("al");
                        }
                        _ => (),
                    }
                }
                _ => (),
            }
        }
        result
    }
}