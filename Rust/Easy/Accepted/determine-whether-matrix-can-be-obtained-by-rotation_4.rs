impl Solution {
    pub fn find_rotation(mat: Vec<Vec<i32>>, target: Vec<Vec<i32>>) -> bool {
        
        let mut mat = mat;
        for _ in 0..4 {
            let mut rotated = vec![vec![0; mat.len()]; mat.len()];
            for i in 0..mat.len() {
                for j in 0..mat.len() {
                    rotated[i][j] = mat[mat.len() - 1 - j][i];
                }
            }
            mat = rotated;
            if mat == target {
                return true;
            }
        }
        false
    }
}