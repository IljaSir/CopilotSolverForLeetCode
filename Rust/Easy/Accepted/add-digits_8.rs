impl Solution {
    pub fn add_digits(num: i32) -> i32 {
        
        if num == 0 {
            return 0;
        }
        let mut n = num;
        while n >= 10 {
            let mut sum = 0;
            while n > 0 {
                sum += n % 10;
                n /= 10;
            }
            n = sum;
        }
        return n;
    }
}