impl Solution {
    pub fn transpose(matrix: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
        
        let mut res: Vec<Vec<i32>> = vec![];
        let m = matrix.len();
        let n = matrix[0].len();
        for i in 0..n {
            let mut row: Vec<i32> = vec![];
            for j in 0..m {
                row.push(matrix[j][i]);
            }
            res.push(row);
        }
        res
    }
}