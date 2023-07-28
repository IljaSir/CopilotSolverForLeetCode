impl Solution {
    pub fn max_value(n: String, x: i32) -> String {
        
        let mut n = n;
        if n.starts_with('-') {
            let x = (x + '0' as i32) as u8;
            let mut i = 1;
            while i < n.len() && n.as_bytes()[i] <= x {
                i += 1;
            }
            n.insert(i, x as char);
        } else {
            let x = (x + '0' as i32) as u8;
            let mut i = 0;
            while i < n.len() && n.as_bytes()[i] >= x {
                i += 1;
            }
            n.insert(i, x as char);
        }
        n
    }
}