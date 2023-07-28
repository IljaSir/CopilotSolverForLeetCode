impl Solution {
    pub fn interpret(command: String) -> String {
        
        let mut res = String::new();
        let mut iter = command.chars();
        while let Some(c) = iter.next() {
            if c == 'G' {
                res.push(c);
            } else if c == '(' {
                if let Some(next) = iter.next() {
                    if next == ')' {
                        res.push('o');
                    } else {
                        res.push_str("al");
                    }
                }
            }
        }
        res
    }
}