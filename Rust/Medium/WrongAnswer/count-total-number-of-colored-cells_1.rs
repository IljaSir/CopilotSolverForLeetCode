impl Solution {
    pub fn colored_cells(n: i32) -> i64 {
        
        let n = n as i64;
        let mut res = 0;
        for i in 1..=n {
            res += 4 * i * i - 4 * i + 1;
        }
        res
    }
}