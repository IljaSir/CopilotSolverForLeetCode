impl Solution {
    pub fn query_string(s: String, n: i32) -> bool {
        
        let mut s = s;
        let mut n = n;
        while n > 0 {
            let s1 = format!("{:b}", n);
            if !s.contains(&s1) {
                return false;
            }
            n -= 1;
        }
        true
    }
}