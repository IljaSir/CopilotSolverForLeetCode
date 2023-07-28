impl Solution {
    pub fn num_steps(s: String) -> i32 {
        
        let mut n = s.parse::<i32>().unwrap();
        let mut res = 0;
        while n > 1 {
            if n % 2 == 0 {
                n /= 2;
            } else {
                n += 1;
            }
            res += 1;
        }
        res
    }
}