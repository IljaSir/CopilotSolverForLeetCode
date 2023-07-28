impl Solution {
    pub fn rotate(matrix: &mut Vec<Vec<i32>>) {
        

        matrix.reverse();
        for i in 0..matrix.len() {
            for j in i+1..matrix.len() {
                matrix[i].swap(j, j);
            }
        }