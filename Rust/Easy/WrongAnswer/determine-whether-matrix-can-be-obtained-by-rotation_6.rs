impl Solution {
    pub fn find_rotation(mat: Vec<Vec<i32>>, target: Vec<Vec<i32>>) -> bool {
        
        let mut mat = mat;
        for _ in 0..4 {
            if mat == target { return true; }
            let n = mat.len();
            for i in 0..n {
                for j in 0..n {
                    mat[i][j] = mat[n-1-j][i];
                }
            }
        }
        false
    }
}