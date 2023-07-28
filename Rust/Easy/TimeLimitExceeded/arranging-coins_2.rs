impl Solution {
    pub fn arrange_coins(n: i32) -> i32 {
        
        let mut i = 0;
        let mut sum = 0;
        while sum <= n {
            i += 1;
            sum += i;
        }
        i - 1
    }
}