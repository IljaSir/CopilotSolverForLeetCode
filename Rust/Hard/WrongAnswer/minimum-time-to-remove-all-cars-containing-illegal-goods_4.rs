impl Solution {
    pub fn minimum_time(s: String) -> i32 {
        
        let mut zero = 0;
        let mut one = 0;
        let mut res = 0;
        for c in s.chars() {
            if c == '0' {
                zero += 1;
                res = res.max(one);
            } else {
                one += 1;
            }
        }
        res.max(one) * 2 - (zero > 0) as i32
    }
}