impl Solution {
    pub fn get_lucky(s: String, k: i32) -> i32 {
        
        let mut r = 0;
        for c in s.chars() {
            let mut n = (c as u8 - b'a') as i32 + 1;
            while n > 0 {
                r += n % 10;
                n /= 10;
            }
        }
        for _ in 1..k {
            let mut n = r;
            r = 0;
            while n > 0 {
                r += n % 10;
                n /= 10;
            }
        }
        r
    }
}