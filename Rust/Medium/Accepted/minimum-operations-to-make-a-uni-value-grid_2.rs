impl Solution {
    pub fn min_operations(grid: Vec<Vec<i32>>, x: i32) -> i32 {
        
        let mut a = grid.into_iter().flatten().collect::<Vec<_>>();
        a.sort();
        let mut ans = 0;
        let n = a.len() as i32;
        let m = a[n as usize/2];
        for i in &a {
            let diff = i-m;
            if diff % x != 0 {
                return -1;
            }
            ans += diff.abs()/x;
        }
        ans
    }
}