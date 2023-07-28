impl Solution {
    pub fn query_string(s: String, n: i32) -> bool {
        
        let mut result = true;
        for i in 1..=n {
            let s = format!("{:b}", i);
            if !s.contains(&s) {
                result = false;
                break;
            }
        }
        result
    }
}