impl Solution {
    pub fn interpret(command: String) -> String {
        
        let mut res = String::new();
        let mut i = 0;
        let bytes = command.as_bytes();
        while i < bytes.len() {
            if bytes[i] == b'G' {
                res.push('G');
                i += 1;
            } else if bytes[i] == b'(' && bytes[i + 1] == b')' {
                res.push('o');
                i += 2;
            } else if bytes[i] == b'(' && bytes[i + 1] == b'a' {
                res.push_str("al");
                i += 4;
            }
        }
        res
    }
}