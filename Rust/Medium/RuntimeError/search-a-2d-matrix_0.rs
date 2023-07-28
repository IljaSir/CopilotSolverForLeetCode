impl Solution {
    pub fn search_matrix(matrix: Vec<Vec<i32>>, target: i32) -> bool {
        

        let m = matrix.len();
        let n = matrix[0].len();
        let mut l = 0;
        let mut r = m * n - 1;
        while l <= r {
            let mid = (l + r) / 2;
            let mid_val = matrix[mid / n][mid % n];
            if mid_val == target {
                return true;
            } else if mid_val < target {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        false
    }
}