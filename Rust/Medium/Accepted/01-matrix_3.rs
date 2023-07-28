impl Solution {
    pub fn update_matrix(mat: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
        

        let mut res = vec![vec![0; mat[0].len()]; mat.len()];
        let mut queue: Vec<(usize, usize)> = Vec::new();
        for i in 0..mat.len() {
            for j in 0..mat[i].len() {
                if mat[i][j] == 0 {
                    queue.push((i, j));
                } else {
                    res[i][j] = -1;
                }
            }
        }
        let mut step = 1;
        while !queue.is_empty() {
            let mut new_queue: Vec<(usize, usize)> = Vec::new();
            for (i, j) in queue {
                if i > 0 && res[i-1][j] == -1 {
                    res[i-1][j] = step;
                    new_queue.push((i-1, j));
                }
                if i < mat.len()-1 && res[i+1][j] == -1 {
                    res[i+1][j] = step;
                    new_queue.push((i+1, j));
                }
                if j > 0 && res[i][j-1] == -1 {
                    res[i][j-1] = step;
                    new_queue.push((i, j-1));
                }
                if j < mat[i].len()-1 && res[i][j+1] == -1 {
                    res[i][j+1] = step;
                    new_queue.push((i, j+1));
                }
            }
            queue = new_queue;
            step += 1;
        }
        res
    }
}