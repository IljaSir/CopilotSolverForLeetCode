impl Solution {
    pub fn find_peak_grid(mat: Vec<Vec<i32>>) -> Vec<i32> {
        
        let m = mat.len();
        let n = mat[0].len();
        let mut l = 0;
        let mut r = n - 1;
        while l <= r {
            let mid = (l + r) / 2;
            let mut max = 0;
            let mut idx = 0;
            for i in 0..m {
                if mat[i][mid] > max {
                    max = mat[i][mid];
                    idx = i;
                }
            }
            if mat[idx][mid] > mat[idx][mid + 1] && mat[idx][mid] > mat[idx][mid - 1] {
                return vec![idx as i32, mid as i32];
            } else if mat[idx][mid] < mat[idx][mid + 1] {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        vec![]
    }
}