impl Solution {
    pub fn max_value(n: String, x: i32) -> String {
        
        let mut res = String::new();
        let mut i = 0;
        if n.as_bytes()[0] == b'-' {
            res.push('-');
            i += 1;
            while i < n.len() && n.as_bytes()[i] <= b'0' + x as u8 {
                res.push(n.as_bytes()[i] as char);
                i += 1;
            }
        } else {
            while i < n.len() && n.as_bytes()[i] >= b'0' + x as u8 {
                res.push(n.as_bytes()[i] as char);
                i += 1;
            }
        }
        res.push(x.to_string().as_bytes()[0] as char);
        while i < n.len() {
            res.push(n.as_bytes()[i] as char);
            i += 1;
        }
        res
    }
}