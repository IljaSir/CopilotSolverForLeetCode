impl Solution {
    pub fn minimum_numbers(num: i32, k: i32) -> i32 {
        
        let mut num = num;
        let mut count = 0;
        while num > 0 {
            if num % 10 <= k {
                num -= num % 10;
            } else {
                num += 10 - num % 10;
            }
            count += 1;
        }
        count
    }
}