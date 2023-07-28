impl Solution {
    pub fn largest_local(grid: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
        
        let mut result = vec![vec![0; grid.len()-2]; grid.len()-2];
        let mut max = 0;
        for i in 0..grid.len()-2 {
            for j in 0..grid.len()-2 {
                max = 0;
                for x in i..i+3 {
                    for y in j..j+3 {
                        if grid[x][y] > max {
                            max = grid[x][y];
                        }
                    }
                }
                result[i][j] = max;
            }
        }
        result
    }
}