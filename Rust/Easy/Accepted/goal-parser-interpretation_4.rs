impl Solution {
    pub fn interpret(command: String) -> String {
        
        let mut result = String::new();
        let mut chars = command.chars();
        while let Some(c) = chars.next() {
            if c == 'G' {
                result.push('G');
            } else if c == '(' {
                if let Some(c) = chars.next() {
                    if c == ')' {
                        result.push('o');
                    } else if c == 'a' {
                        if let Some(c) = chars.next() {
                            if c == 'l' {
                                if let Some(c) = chars.next() {
                                    if c == ')' {
                                        result.push_str("al");
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        result
    }
}