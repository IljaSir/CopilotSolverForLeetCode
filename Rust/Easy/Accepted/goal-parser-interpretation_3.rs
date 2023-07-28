impl Solution {
    pub fn interpret(command: String) -> String {
        
        let mut res = String::new();
        let mut i = 0;
        while i < command.len() {
            if command[i..].starts_with("G") {
                res.push('G');
                i += 1;
            } else if command[i..].starts_with("()") {
                res.push('o');
                i += 2;
            } else if command[i..].starts_with("(al)") {
                res.push_str("al");
                i += 4;
            } else {
                unreachable!();
            }
        }
        res
    }
}