impl Solution {
    pub fn range_add_queries(n: i32, queries: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
        
        let mut mat = vec![vec![0; n as usize]; n as usize];
        for query in queries.iter() {
            for i in query[0] as usize..=query[2] as usize {
                mat[i][query[1] as usize] += 1;
                if query[3] + 1 < n {
                    mat[i][(query[3] + 1) as usize] -= 1;
                }
            }
        }
        for i in 0..n as usize {
            for j in 1..n as usize {
                mat[i][j] += mat[i][j - 1];
            }
        }
        mat
    }
}