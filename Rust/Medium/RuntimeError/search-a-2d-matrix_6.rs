impl Solution {
    pub fn search_matrix(matrix: Vec<Vec<i32>>, target: i32) -> bool {
        

        let mut l = 0;
        let mut r = matrix.len() * matrix[0].len() - 1;
        while l <= r {
            let mid = (l + r) / 2;
            let i = mid / matrix[0].len();
            let j = mid % matrix[0].len();
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