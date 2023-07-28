impl Solution {
    pub fn count_even(num: i32) -> i32 {
        
        let mut res = 0;
        for i in 1..=num {
            let mut sum = 0;
            let mut num = i;
            while num > 0 {
                sum += num % 10;
                num /= 10;
            }
            if sum % 2 == 0 {
                res += 1;
            }
        }
        res
    }
}