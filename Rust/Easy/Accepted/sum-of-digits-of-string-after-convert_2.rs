impl Solution {
    pub fn get_lucky(s: String, k: i32) -> i32 {
        
        let mut sum = 0;
        for c in s.chars() {
            let n = c as i32 - 'a' as i32 + 1;
            sum += n / 10;
            sum += n % 10;
        }
        let mut res = sum;
        for _ in 0..k - 1 {
            res = Self::sum_digits(res);
        }
        res
    }
    fn sum_digits(n: i32) -> i32 {
        let mut sum = 0;
        let mut n = n;
        while n > 0 {
            sum += n % 10;
            n /= 10;
        }
        sum
    }
}