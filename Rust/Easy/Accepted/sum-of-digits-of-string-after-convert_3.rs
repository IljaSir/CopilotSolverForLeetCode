impl Solution {
    pub fn get_lucky(s: String, k: i32) -> i32 {
        
        let mut sum = 0;
        for c in s.chars() {
            let mut n = c as i32 - 96;
            while n > 0 {
                sum += n % 10;
                n /= 10;
            }
        }
        let mut k = k - 1;
        while k > 0 {
            let mut n = sum;
            sum = 0;
            while n > 0 {
                sum += n % 10;
                n /= 10;
            }
            k -= 1;
        }
        sum
    }
}