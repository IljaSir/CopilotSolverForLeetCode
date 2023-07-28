impl Solution {
    pub fn query_string(s: String, n: i32) -> bool {
        
        let mut n = n;
        while n > 0 {
            if !s.contains(&format!("{:b}", n)) {
                return false;
            }
            n -= 1;
        }
        true
    }
}