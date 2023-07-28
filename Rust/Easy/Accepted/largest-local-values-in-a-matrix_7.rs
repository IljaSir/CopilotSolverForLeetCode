impl Solution {
    pub fn largest_local(grid: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
        
        let mut max_local = vec![];
        let n = grid.len();
        for i in 1..n-1 {
            let mut row = vec![];
            for j in 1..n-1 {
                let mut max = 0;
                for ii in i-1..i+2 {
                    for jj in j-1..j+2 {
                        max = std::cmp::max(max, grid[ii][jj]);
                    }
                }
                row.push(max);
            }
            max_local.push(row);
        }
        max_local
    }
}