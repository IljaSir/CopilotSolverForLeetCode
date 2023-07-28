impl Solution {
    pub fn thousand_separator(n: i32) -> String {
        
        let mut s = n.to_string();
        let mut i = s.len() - 3;
        while i > 0 {
            s.insert(i, '.');
            i -= 3;
        }
        s
    }
}