impl Solution {
    pub fn pivot_integer(n: i32) -> i32 {
        
        let mut sum = 0;
        for i in 1..=n {
            sum += i;
        }
        let mut left = 0;
        for i in 1..=n {
            if left == sum - left - i {
                return i;
            }
            left += i;
        }
        -1
    }
}