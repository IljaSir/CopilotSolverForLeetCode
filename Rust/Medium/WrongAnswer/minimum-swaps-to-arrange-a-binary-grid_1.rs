impl Solution {
    pub fn min_swaps(grid: Vec<Vec<i32>>) -> i32 {
        
        let mut grid = grid;
        let mut res = 0;
        for i in 0..grid.len() {
            let mut found = false;
            for j in i..grid.len() {
                if grid[j][i] == 1 {
                    found = true;
                    for k in (i..j).rev() {
                        grid.swap(k, k + 1);
                        res += 1;
                    }
                    break;
                }
            }
            if !found {
                return -1;
            }
        }
        res as i32
    }
}