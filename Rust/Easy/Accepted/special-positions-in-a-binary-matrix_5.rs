impl Solution {
    pub fn num_special(mat: Vec<Vec<i32>>) -> i32 {
        
        let mut count = 0;
        for i in 0..mat.len() {
            for j in 0..mat[i].len() {
                if mat[i][j] == 1 && Solution::is_special(&mat, i, j) {
                    count += 1;
                }
            }
        }
        count
    }
    fn is_special(mat: &Vec<Vec<i32>>, row: usize, col: usize) -> bool {
        let mut count = 0;
        for i in 0..mat.len() {
            if mat[i][col] == 1 {
                count += 1;
            }
        }
        if count > 1 {
            return false;
        }
        count = 0;
        for j in 0..mat[row].len() {
            if mat[row][j] == 1 {
                count += 1;
            }
        }
        count == 1
    }
}