impl Solution {
    pub fn colored_cells(n: i32) -> i64 {
        
        let n = n as i64;
        (n * n * 3) - (n * 2 - 1) * 2
    }
}