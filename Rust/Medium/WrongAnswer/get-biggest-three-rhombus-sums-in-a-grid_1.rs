impl Solution {
    pub fn get_biggest_three(grid: Vec<Vec<i32>>) -> Vec<i32> {
        
        let m = grid.len();
        let n = grid[0].len();
        let mut sums = vec![];
        for i in 0..m {
            for j in 0..n {
                let mut k = 1;
                while i >= k && j >= k && i + k < m && j + k < n {
                    let sum = grid[i][j - k] + grid[i - k][j] + grid[i][j + k] + grid[i + k][j];
                    sums.push(sum);
                    k += 1;
                }
            }
        }
        sums.sort();
        sums.dedup();
        sums.reverse();
        let mut res = vec![];
        for i in 0..3 {
            if i < sums.len() {
                res.push(sums[i]);
            }
        }
        res
    }
}