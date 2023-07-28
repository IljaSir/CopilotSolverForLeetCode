impl Solution {
    pub fn find_rotation(mat: Vec<Vec<i32>>, target: Vec<Vec<i32>>) -> bool {
        
        let n = mat.len();
        let mut m = mat;
        for _ in 0..4 {
            m = Self::rotate(m, n);
            if m == target {
                return true;
            }
        }
        false
    }
    fn rotate(mat: Vec<Vec<i32>>, n: usize) -> Vec<Vec<i32>> {
        let mut m = mat;
        for i in 0..n {
            for j in 0..n {
                m[i][j] = mat[n - 1 - j][i];
            }
        }
        m
    }
}