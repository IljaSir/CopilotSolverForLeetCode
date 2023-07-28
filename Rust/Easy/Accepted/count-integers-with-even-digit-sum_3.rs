impl Solution {
    pub fn count_even(num: i32) -> i32 {
        
        let mut res = 0;
        for i in 1..=num {
            if Self::digit_sum(i) % 2 == 0 {
                res += 1;
            }
        }
        res
    }
    fn digit_sum(mut num: i32) -> i32 {
        let mut sum = 0;
        while num > 0 {
            sum += num % 10;
            num /= 10;
        }
        sum
    }
}