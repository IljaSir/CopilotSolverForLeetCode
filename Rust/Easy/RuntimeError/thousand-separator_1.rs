impl Solution {
    pub fn thousand_separator(n: i32) -> String {
        
        let mut n = n.to_string();
        let mut i = n.len() - 3;
        while i > 0 {
            n.insert(i, '.');
            i -= 3;
        }
        n
    }
}