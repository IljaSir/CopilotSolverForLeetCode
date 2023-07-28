impl Solution {
    pub fn min_operations(grid: Vec<Vec<i32>>, x: i32) -> i32 {
        
        let mut a = grid.into_iter().flatten().collect::<Vec<i32>>();
        a.sort();
        let n = a.len();
        let m = a[n/2];
        a.iter().map(|&i| (i - m).abs()/x).sum()
    }
}