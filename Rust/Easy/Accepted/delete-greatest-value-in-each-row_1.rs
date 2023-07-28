impl Solution {
    pub fn delete_greatest_value(grid: Vec<Vec<i32>>) -> i32 {
        
        let mut grid = grid;
        let mut result = 0;
        while !grid.is_empty() {
            let mut max = 0;
            for i in 0..grid.len() {
                let index = grid[i].iter().enumerate().max_by_key(|&(_, &x)| x).unwrap().0;
                max = max.max(grid[i][index]);
                grid[i].remove(index);
            }
            result += max;
            grid.retain(|x| !x.is_empty());
        }
        result
    }
}