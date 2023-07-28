impl Solution {
    pub fn min_swaps(grid: Vec<Vec<i32>>) -> i32 {
        
        let n = grid.len();
        let mut v = Vec::new();
        for i in 0..n {
            let mut count = 0;
            for j in (0..n).rev() {
                if grid[i][j] == 1 {
                    break;
                }
                count += 1;
            }
            v.push(count);
        }
        let mut ans = 0;
        for i in 0..n {
            if v[i] >= n - i - 1 {
                continue;
            }
            let mut j = i + 1;
            while j < n && v[j] < n - i - 1 {
                j += 1;
            }
            if j == n {
                return -1;
            }
            while j > i {
                v.swap(j, j - 1);
                ans += 1;
                j -= 1;
            }
        }
        ans as i32
    }
}