impl Solution {
    pub fn delete_greatest_value(grid: Vec<Vec<i32>>) -> i32 {
        
        let mut grid = grid;
        let mut ans = 0;
        while !grid.is_empty() {
            let mut max = 0;
            for row in grid.iter_mut() {
                let m = row.iter().max().unwrap();
                max = max.max(*m);
                *row = row.iter().filter(|&&x| x != *m).map(|&x| x).collect();
            }
            grid = grid.iter().filter(|row| !row.is_empty()).map(|row| row.to_vec()).collect();
            ans += max;
        }
        ans
    }
}