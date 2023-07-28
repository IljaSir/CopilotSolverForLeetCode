impl Solution {
    pub fn count_digits(num: i32) -> i32 {
        
        let mut count = 0;
        let mut n = num;
        while n > 0 {
            let i = n % 10;
            if i != 0 && num % i == 0 {
                count += 1;
            }
            n /= 10;
        }
        count
    }
}