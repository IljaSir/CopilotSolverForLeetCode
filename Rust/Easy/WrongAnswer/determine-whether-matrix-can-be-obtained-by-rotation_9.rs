impl Solution {
    pub fn find_rotation(mat: Vec<Vec<i32>>, target: Vec<Vec<i32>>) -> bool {
        
        let n = mat.len();
        if n == 0 {
            return true;
        }
        let mut mat = mat;
        for _ in 0..4 {
            for i in 0..n {
                for j in 0..n {
                    if mat[i][j] != target[i][j] {
                        return false;
                    }
                }
            }
            mat = Self::rotate(mat);
        }
        true
    }
    fn rotate(mat: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
        let n = mat.len();
        let mut res = vec![vec![0; n]; n];
        for i in 0..n {
            for j in 0..n {
                res[i][j] = mat[n - j - 1][i];
            }
        }
        res
    }
}