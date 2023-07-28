impl Solution {
    pub fn image_smoother(img: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
        
        let (m, n) = (img.len(), img[0].len());
        let mut res = vec![vec![0; n]; m];
        let mut count = vec![vec![0; n]; m];
        for i in 0..m {
            for j in 0..n {
                for x in -1..=1 {
                    for y in -1..=1 {
                        if i as i32 + x >= 0 && i as i32 + x < m as i32 && j as i32 + y >= 0 && j as i32 + y < n as i32 {
                            res[i][j] += img[(i as i32 + x) as usize][(j as i32 + y) as usize];
                            count[i][j] += 1;
                        }
                    }
                }
            }
        }
        for i in 0..m {
            for j in 0..n {
                res[i][j] /= count[i][j];
            }
        }
        res
    }
}