impl Solution {
    pub fn pivot_integer(n: i32) -> i32 {
        
        let mut total = 0;
        for i in 1..=n {
            total += i;
        }
        let mut sum = 0;
        for i in 1..=n {
            sum += i;
            if sum * 2 == total {
                return i;
            }
        }
        -1
    }
}