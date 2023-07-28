impl Solution {
    pub fn arrange_coins(n: i32) -> i32 {
        
        let mut sum = 0;
        let mut count = 0;
        let mut n = n as i64;
        while sum <= n {
            count += 1;
            sum += count;
        }
        count - 1
    }
}