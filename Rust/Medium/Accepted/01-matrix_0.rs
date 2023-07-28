impl Solution {
    pub fn update_matrix(mat: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
        

        let mut res = vec![vec![0; mat[0].len()]; mat.len()];
        let mut queue = Vec::new();
        for i in 0..mat.len() {
            for j in 0..mat[0].len() {
                if mat[i][j] == 0 {
                    queue.push((i, j));
                } else {
                    res[i][j] = -1;
                }
            }
        }
        let mut step = 0;
        while !queue.is_empty() {
            let mut next = Vec::new();
            for (i, j) in queue {
                if res[i][j] == -1 {
                    res[i][j] = step;
                }
                if i > 0 && res[i - 1][j] == -1 {
                    next.push((i - 1, j));
                }
                if j > 0 && res[i][j - 1] == -1 {
                    next.push((i, j - 1));
                }
                if i < mat.len() - 1 && res[i + 1][j] == -1 {
                    next.push((i + 1, j));
                }
                if j < mat[0].len() - 1 && res[i][j + 1] == -1 {
                    next.push((i, j + 1));
                }
            }
            queue = next;
            step += 1;
        }
        res
    }
}