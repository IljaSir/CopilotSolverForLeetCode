impl Solution {
    pub fn search_matrix(matrix: Vec<Vec<i32>>, target: i32) -> bool {
        

        let m = matrix.len();
        let n = matrix[0].len();
        let mut l = 0;
        let mut r = m * n - 1;
        while l <= r {
            let mid = l + (r - l) / 2;
            let i = mid / n;
            let j = mid % n;
            if matrix[i][j] == target {
                return true;
            } else if matrix[i][j] < target {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        false
    }
}