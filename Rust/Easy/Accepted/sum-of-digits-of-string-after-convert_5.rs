impl Solution {
    pub fn get_lucky(s: String, k: i32) -> i32 {
        
        let mut res: i32 = 0;
        for c in s.chars() {
            let mut n = c as i32 - 96;
            while n > 0 {
                res += n % 10;
                n /= 10;
            }
        }
        for _ in 1..k {
            let mut n = res;
            res = 0;
            while n > 0 {
                res += n % 10;
                n /= 10;
            }
        }
        res
    }
}