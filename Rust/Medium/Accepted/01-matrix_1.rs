impl Solution {
    pub fn update_matrix(mat: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
        

        let mut result = vec![vec![0; mat[0].len()]; mat.len()];
        let mut queue = Vec::new();
        for i in 0..mat.len() {
            for j in 0..mat[i].len() {
                if mat[i][j] == 0 {
                    queue.push((i, j));
                } else {
                    result[i][j] = std::i32::MAX;
                }
            }
        }
        while !queue.is_empty() {
            let (i, j) = queue.remove(0);
            if i > 0 && result[i][j] + 1 < result[i - 1][j] {
                result[i - 1][j] = result[i][j] + 1;
                queue.push((i - 1, j));
            }
            if i < mat.len() - 1 && result[i][j] + 1 < result[i + 1][j] {
                result[i + 1][j] = result[i][j] + 1;
                queue.push((i + 1, j));
            }
            if j > 0 && result[i][j] + 1 < result[i][j - 1] {
                result[i][j - 1] = result[i][j] + 1;
                queue.push((i, j - 1));
            }
            if j < mat[i].len() - 1 && result[i][j] + 1 < result[i][j + 1] {
                result[i][j + 1] = result[i][j] + 1;
                queue.push((i, j + 1));
            }
        }
        result
    }
}