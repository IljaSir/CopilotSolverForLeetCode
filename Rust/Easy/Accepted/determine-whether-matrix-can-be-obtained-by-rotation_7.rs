impl Solution {
    pub fn find_rotation(mat: Vec<Vec<i32>>, target: Vec<Vec<i32>>) -> bool {
        
        let n = mat.len();
        if n == 1 {
            return mat[0][0] == target[0][0];
        }
        let mut mat = mat;
        for _ in 0..4 {
            mat = Solution::rotate(&mat);
            if mat == target {
                return true;
            }
        }
        false
    }
    fn rotate(mat: &Vec<Vec<i32>>) -> Vec<Vec<i32>> {
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