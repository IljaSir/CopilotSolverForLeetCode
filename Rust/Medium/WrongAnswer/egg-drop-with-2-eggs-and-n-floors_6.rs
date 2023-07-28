impl Solution {
    pub fn two_egg_drop(n: i32) -> i32 {
        
        let n = n as i64;
        let mut k = 1;
        let mut cnt = 0;
        while k * (k + 1) / 2 < n {
            cnt += 1;
            k += 1;
        }
        cnt
    }
}