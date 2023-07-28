impl Solution {
    pub fn thousand_separator(n: i32) -> String {
        
        let mut s = n.to_string();
        let mut i = s.len();
        while i > 3 {
            i -= 3;
            s.insert(i, '.');
        }
        s
    }
}