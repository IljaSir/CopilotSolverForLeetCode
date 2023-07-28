impl Solution {
    pub fn search_matrix(matrix: Vec<Vec<i32>>, target: i32) -> bool {
        

        let mut start = 0;
        let mut end = matrix.len() * matrix[0].len();
        while start < end {
            let mid = start + (end - start) / 2;
            let row = mid / matrix[0].len();
            let col = mid % matrix[0].len();
            if matrix[row][col] == target {
                return true;
            } else if matrix[row][col] < target {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        false
    }
}