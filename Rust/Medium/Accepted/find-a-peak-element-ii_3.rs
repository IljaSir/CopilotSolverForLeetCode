impl Solution {
    pub fn find_peak_grid(mat: Vec<Vec<i32>>) -> Vec<i32> {
        
        let (m, n) = (mat.len(), mat[0].len());
        let mut left = 0;
        let mut right = n;
        let mut mid;
        let mut max_i = 0;
        let mut max_j = 0;
        while left < right {
            mid = (left + right) / 2;
            let mut max = 0;
            for i in 0..m {
                if mat[i][mid] > max {
                    max = mat[i][mid];
                    max_i = i;
                    max_j = mid;
                }
            }
            if max_j > 0 && mat[max_i][max_j - 1] > max {
                right = mid;
            } else if max_j < n - 1 && mat[max_i][max_j + 1] > max {
                left = mid + 1;
            } else {
                break;
            }
        }
        vec![max_i as i32, max_j as i32]
    }
}