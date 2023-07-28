impl Solution {
    pub fn min_swaps(grid: Vec<Vec<i32>>) -> i32 {
        
        let mut zeros = vec![0; grid.len()];
        for (i, row) in grid.iter().enumerate() {
            let mut z = 0;
            for &n in row.iter().rev() {
                if n == 0 {
                    z += 1;
                } else {
                    break;
            
            =
            zeros[i] = z;
        }
        let mut ans = 0;
        for i in 0..grid.len() {
            let mut j = i;
            while j < grid.len() && zeros[j] < grid.len() - i - 1 {
                j += 1;
            }
            if j == grid.len() {
                return -1;
            }
            ans += j - i;
            zeros.remove(j);
            zeros.insert(i, 0);
        }
        ans as i32
    }
}