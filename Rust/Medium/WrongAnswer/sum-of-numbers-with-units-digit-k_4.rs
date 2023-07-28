impl Solution {
    pub fn minimum_numbers(num: i32, k: i32) -> i32 {
        
        let mut sum = num;
        let mut count = 0;
        while sum > 0 {
            if sum % 10 >= k {
                count += 1;
                sum = sum / 10 + 1;
            } else {
                sum /= 10;
            }
        }
        count
    }
}