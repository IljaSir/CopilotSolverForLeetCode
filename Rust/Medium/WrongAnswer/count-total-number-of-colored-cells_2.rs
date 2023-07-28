impl Solution {
    pub fn colored_cells(n: i32) -> i64 {
        
        let n = n as i64;
        let mut ans = 0;
        for i in 0..n {
            ans += 4 * i * (n - i - 1);
        }
        ans + n * n
    }
}