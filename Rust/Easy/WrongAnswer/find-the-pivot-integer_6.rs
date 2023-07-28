impl Solution {
    pub fn pivot_integer(n: i32) -> i32 {
        
        let mut sum = 0;
        let mut sum2 = 0;
        for i in 1..=n {
            sum += i;
        }
        for i in 1..=n {
            sum2 += i;
            if sum2 == sum - sum2 {
                return i;
            }
        }
        -1
    }
}