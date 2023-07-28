impl Solution {
    pub fn search_matrix(matrix: Vec<Vec<i32>>, target: i32) -> bool {
        

        let mut i = 0;
        let mut j = matrix[0].len() - 1;
        while i < matrix.len() && j < matrix[0].len() {
            let v = matrix[i][j];
            if v == target {
                return true;
            } else if v < target {
                i += 1;
            } else {
                if j == 0 {
                    break;
                }
                j -= 1;
            }
        }
        false
    }
}