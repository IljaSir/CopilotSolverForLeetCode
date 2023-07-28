impl Solution {
    pub fn largest_local(grid: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
        
        let mut max_local = vec![];
        for i in 1..grid.len()-1 {
            let mut row = vec![];
            for j in 1..grid[i].len()-1 {
                let mut max = 0;
                for k in 0..3 {
                    for l in 0..3 {
                        max = max.max(grid[i-1+k][j-1+l]);
                    }
                }
                row.push(max);
            }
            max_local.push(row);
        }
        max_local
    }
}