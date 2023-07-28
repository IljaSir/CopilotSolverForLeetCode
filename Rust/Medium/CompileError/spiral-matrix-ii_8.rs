impl Solution {
    pub fn generate_matrix(n: i32) -> Vec<Vec<i32>> {
        

        let mut matrix = vec![vec![0; n as usize]; n as usize];
        let mut num = 1;
        let mut i = 0;
        let mut j = 0;
        let mut d = 0;
        let di = vec![0, 1, 0, -1];
        let dj = vec![1, 0, -1, 0];
        while num <= n * n {
            matrix[i][j] = num;
            num += 1;
            if i + di[d] < 0 || i + di[d] >= n as usize || j + dj[d] < 0 || j + dj[d] >= n as usize || matrix[i + di[d]][j + dj[d]] != 0 {
                d = (d + 1) % 4;
            }
            i += di[d];
            j += dj[d];
        }
        matrix
    }
}