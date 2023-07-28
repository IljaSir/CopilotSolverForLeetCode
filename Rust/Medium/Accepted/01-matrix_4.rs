impl Solution {
    pub fn update_matrix(mat: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
        

        let mut ans = vec![vec![0; mat[0].len()]; mat.len()];
        let mut q = std::collections::VecDeque::new();
        for (i, row) in mat.iter().enumerate() {
            for (j, &v) in row.iter().enumerate() {
                if v == 0 {
                    q.push_back((i, j));
                } else {
                    ans[i][j] = i32::MAX;
                }
            }
        }
        let mut dir = vec![(0, 1), (1, 0), (0, -1), (-1, 0)];
        while let Some((i, j)) = q.pop_front() {
            for (di, dj) in dir.iter() {
                let ni = i as i32 + di;
                let nj = j as i32 + dj;
                if ni >= 0 && ni < mat.len() as i32 && nj >= 0 && nj < mat[0].len() as i32 {
                    let ni = ni as usize;
                    let nj = nj as usize;
                    if ans[ni][nj] > ans[i][j] + 1 {
                        ans[ni][nj] = ans[i][j] + 1;
                        q.push_back((ni, nj));
                    }
                }
            }
        }
        ans
    }
}