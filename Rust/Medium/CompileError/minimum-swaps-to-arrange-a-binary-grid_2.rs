impl Solution {
    pub fn min_swaps(grid: Vec<Vec<i32>>) -> i32 {
        
        let n = grid.len();
        let mut a: Vec<i32> = vec![0; n];
        for i in 0..n {
            let mut c = 0;
            for j in (0..n).rev() {
                if grid[i][j] == 0 {
                    c += 1;
                } else {
                    break;
                }
            }
            a[i] = c;
        }
        let mut ans = 0;
        for i in 0..n {
            if a[i] >= n - 1 - i {
                continue;
            }
            let mut j = i + 1;
            while j < n && a[j] < n - 1 - i {
                j += 1;
            }
            if j == n {
                return -1;
            }
            ans += j - i;
            while j > i {
                a.swap(j, j - 1);
                j -= 1;
            }
        }
        ans as i32
    }
}