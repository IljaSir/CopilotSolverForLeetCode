impl Solution {
    pub fn min_swaps(grid: Vec<Vec<i32>>) -> i32 {
        
        let mut arr = vec![];
        let n = grid.len();
        for i in 0..n {
            let mut j = n - 1;
            while j > 0 && grid[i][j] == 0 {
                j -= 1;
            }
            arr.push(j);
        }
        // println!("{:?}", arr);
        let mut ans = 0;
        for i in 0..n - 1 {
            let mut j = i;
            while j < n && arr[j] <= i {
                j += 1;
            }
            if j == n {
                return -1;
            }
            while j > i {
                arr.swap(j, j - 1);
                ans += 1;
                j -= 1;
            }
        }
        ans as i32
    }
}