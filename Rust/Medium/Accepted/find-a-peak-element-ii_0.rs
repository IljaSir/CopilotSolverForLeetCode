impl Solution {
    pub fn find_peak_grid(mat: Vec<Vec<i32>>) -> Vec<i32> {
        
        let m = mat.len();
        let n = mat[0].len();
        let mut left = 0;
        let mut right = n - 1;
        while left < right {
            let mid = (left + right) / 2;
            let mut max_i = 0;
            for i in 0..m {
                if mat[i][mid] > mat[max_i][mid] {
                    max_i = i;
                }
            }
            if mat[max_i][mid] < mat[max_i][mid + 1] {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        let mut max_i = 0;
        for i in 0..m {
            if mat[i][left] > mat[max_i][left] {
                max_i = i;
            }
        }
        vec![max_i as i32, left as i32]
    }
}