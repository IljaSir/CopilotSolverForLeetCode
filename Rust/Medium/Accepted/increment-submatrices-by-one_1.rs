impl Solution {
    pub fn range_add_queries(n: i32, queries: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
        
        let mut mat = vec![vec![0; n as usize]; n as usize];
        for query in queries {
            let row1 = query[0] as usize;
            let col1 = query[1] as usize;
            let row2 = query[2] as usize;
            let col2 = query[3] as usize;
            for row in row1..=row2 {
                mat[row][col1] += 1;
                if col2 < n as usize - 1 {
                    mat[row][col2 + 1] -= 1;
                }
            }
        }
        for row in 0..n as usize {
            for col in 1..n as usize {
                mat[row][col] += mat[row][col - 1];
            }
        }
        mat
    }
}