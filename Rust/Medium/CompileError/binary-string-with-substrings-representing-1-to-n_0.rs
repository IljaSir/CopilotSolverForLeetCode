impl Solution {
    pub fn query_string(s: String, n: i32) -> bool {
        
        for i in 1..=n {
            if !s.contains(&i.to_string(2)) {
                return false;
            }
        }
        true
    }
}