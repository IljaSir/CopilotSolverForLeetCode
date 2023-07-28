impl Solution {
    pub fn count_sub_islands(grid1: Vec<Vec<i32>>, grid2: Vec<Vec<i32>>) -> i32 {
        
        let mut grid2 = grid2;
        let mut count = 0;
        for i in 0..grid2.len() {
            for j in 0..grid2[i].len() {
                if grid2[i][j] == 1 {
                    if Self::dfs(&grid1, &mut grid2, i, j) {
                        count += 1;
                    }
                }
            }
        }
        count
    }
    fn dfs(
        grid1: &Vec<Vec<i32>>,
        grid2: &mut Vec<Vec<i32>>,
        i: usize,
        j: usize,
    ) -> bool {
        if i >= grid1.len()
            || j >= grid1[i].len()
            || grid1[i][j] == 0
            || grid2[i][j] == 0
        {
            return false;
        }
        grid2[i][j] = 0;
        let mut res = true;
        if i > 0 {
            res &= Self::dfs(grid1, grid2, i - 1, j);
        }
        if j > 0 {
            res &= Self::dfs(grid1, grid2, i, j - 1);
        }
        if i < grid1.len() - 1 {
            res &= Self::dfs(grid1, grid2, i + 1, j);
        }
        if j < grid1[i].len() - 1 {
            res &= Self::dfs(grid1, grid2, i, j + 1);
        }
        res
    }
}