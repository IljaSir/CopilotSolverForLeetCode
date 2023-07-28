impl Solution {
    pub fn search_matrix(matrix: Vec<Vec<i32>>, target: i32) -> bool {
        

        let (m, n) = (matrix.len(), matrix[0].len());
        let (mut i, mut j) = (0, m * n - 1);
        while i <= j {
            let mid = (i + j) / 2;
            let (x, y) = (mid / n, mid % n);
            if matrix[x][y] == target {
                return true;
            } else if matrix[x][y] < target {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        false
    }
}