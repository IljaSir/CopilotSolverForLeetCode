impl Solution {
    pub fn min_swaps(grid: Vec<Vec<i32>>) -> i32 {
        
        let n = grid.len();
        let mut vec = vec![0; n];
        for (i, row) in grid.iter().enumerate() {
            let mut cnt = 0;
            for j in (0..n).rev() {
                if row[j] == 0 {
                    cnt += 1;
                } else {
                    break;
                }
            }
            vec[i] = cnt;
        }
        let mut ans = 0;
        for i in 0..n {
            let mut j = i;
            while j < n && vec[j] < n - i - 1 {
                j += 1;
            }
            if j == n {
                return -1;
            }
            ans += j - i;
            for k in (i + 1..=j).rev() {
                vec.swap(k, k - 1);
            }
        }
        ans as i32======

        let n = grid.len();
        let mut grid = grid;
        let mut zeros = vec![0; n];
        for i in 0..n {
            let mut j = n - 1;
            while j >= 0 && grid[i][j] == 0 {
                j -= 1;
            }
            zeros[i] = j;
        }
        let mut ans = 0;
        for i in 0..n {
            let mut j = i;
            while j < n && zeros[j] < i {
                j += 1;
            }
            if j == n {
                return -1;
            }
            ans += j - i;
            while j > i {
                zeros.swap(j, j - 1);
                j -= 1;
            }
        }
        ans as i32
    }
}