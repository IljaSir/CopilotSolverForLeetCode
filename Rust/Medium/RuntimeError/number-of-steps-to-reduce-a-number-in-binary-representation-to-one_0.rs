impl Solution {
    pub fn num_steps(s: String) -> i32 {
        
        let mut n = i64::from_str_radix(&s, 2).unwrap();
        let mut count = 0;
        while n > 1 {
            if n % 2 == 0 {
                n /= 2;
            } else {
                n += 1;
            }
            count += 1;
        }
        count
    }
}