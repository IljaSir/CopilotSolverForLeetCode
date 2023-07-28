impl Solution {
    pub fn find_rotation(mat: Vec<Vec<i32>>, target: Vec<Vec<i32>>) -> bool {
        
        let n = mat.len();
        let mut mat = mat;
        let mut target = target;
        for _ in 0..4 {
            for i in 0..n {
                for j in 0..n {
                    if mat[i][j] != target[i][j] {
                        return false;
                    }
                }
            }
            for i in 0..n {
                for j in 0..n {
                    mat[i][j] = mat[n - 1 - j][i];
                }
            }
        }
        true
    }
}