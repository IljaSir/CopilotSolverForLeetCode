impl Solution {
    pub fn max_value(n: String, x: i32) -> String {
        
        let mut n = n.as_bytes();
        let mut i = 0;
        let mut x = x as u8;
        if n[0] == b'-' {
            while i < n.len() && n[i] == b'-' || n[i] <= x {
                i += 1;
            }
        } else {
            while i < n.len() && n[i] == b'-' || n[i] >= x {
                i += 1;
            }
        }
        let mut res = Vec::new();
        res.extend_from_slice(&n[..i]);
        res.push(x);
        res.extend_from_slice(&n[i..]);
        String::from_utf8(res).unwrap()
    }
}