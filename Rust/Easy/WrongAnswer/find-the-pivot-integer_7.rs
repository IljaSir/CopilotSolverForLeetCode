impl Solution {
    pub fn pivot_integer(n: i32) -> i32 {
        
        if n == 1 {
            return 1;
        }
        let mut sum = 0;
        for i in 1..=n {
            sum += i;
            if sum == (n * (n + 1) / 2 - sum) {
                return i;
            }
        }
        -1
    }
}