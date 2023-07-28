impl Solution {
    pub fn transpose(matrix: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
        
        let mut res: Vec<Vec<i32>> = vec![];
        for i in 0..matrix[0].len() {
            let mut tmp: Vec<i32> = vec![];
            for j in 0..matrix.len() {
                tmp.push(matrix[j][i]);
            }
            res.push(tmp);
        }
        res
    }
}