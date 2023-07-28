impl Solution {
    pub fn arrange_coins(n: i32) -> i32 {
        
        let n = n as i64;
        let mut i = 0;
        while i * (i + 1) / 2 <= n {
            i += 1;
        }
        (i - 1) as i32
    }
}