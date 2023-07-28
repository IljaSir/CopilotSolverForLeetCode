impl Solution {
    pub fn search_matrix(matrix: Vec<Vec<i32>>, target: i32) -> bool {
        

        let (mut i, mut j) = (0, matrix.len() - 1);
        while i <= j {
            let k = (i + j) / 2;
            if matrix[k][0] <= target && target <= matrix[k][matrix[k].len() - 1] {
                let (mut i, mut j) = (0, matrix[k].len() - 1);
                while i <= j {
                    let l = (i + j) / 2;
                    if matrix[k][l] == target {
                        return true;
                    } else if matrix[k][l] < target {
                        i = l + 1;
                    } else {
                        j = l - 1;
                    }
                }
                return false;
            } else if target < matrix[k][0] {
                j = k - 1;
            } else {
                i = k + 1;
            }
        }
        false
    }
}