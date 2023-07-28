impl Solution {
    pub fn find_rotation(mat: Vec<Vec<i32>>, target: Vec<Vec<i32>>) -> bool {
        
        let n = mat.len();
        let mut mat = mat;
        for _ in 0..4 {
            let mut tmp = vec![vec![0; n]; n];
            for i in 0..n {
                for j in 0..n {
                    tmp[j][n - i - 1] = mat[i][j];
                }
            }
            if tmp == target {
                return true;
            }
            mat = tmp;
        }
        false
    }
}