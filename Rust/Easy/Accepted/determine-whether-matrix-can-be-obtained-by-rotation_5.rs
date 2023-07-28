impl Solution {
    pub fn find_rotation(mat: Vec<Vec<i32>>, target: Vec<Vec<i32>>) -> bool {
        
        let n = mat.len();
        let mut mat = mat;
        for _ in 0..4 {
            mat = (0..n).map(|i| (0..n).map(|j| mat[j][n - 1 - i]).collect()).collect();
            if mat == target {
                return true;
            }
        }
        false
    }
}