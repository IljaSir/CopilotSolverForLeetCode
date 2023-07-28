impl Solution {
    pub fn min_swaps(grid: Vec<Vec<i32>>) -> i32 {
        
        let mut count = 0;
        let mut grid = grid;
        let n = grid.len();
        for i in 0..n {
            let mut j = i;
            while j < n && grid[j][i] == 0 {
                j += 1;
            }
            if j == n {
                return -1;
            }
            for k in (i+1..j).rev() {
                grid.swap(k, k-1);
                count += 1;
            }
        }
        count
    }
}