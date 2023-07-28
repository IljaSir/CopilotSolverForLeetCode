impl Solution {
    pub fn image_smoother(img: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
        
        let m = img.len();
        let n = img[0].len();
        let mut result = vec![vec![0; n]; m];
        for i in 0..m {
            for j in 0..n {
                let mut sum = 0;
                let mut count = 0;
                for x in -1..=1 {
                    for y in -1..=1 {
                        if i as i32 + x >= 0 && i as i32 + x < m as i32 && j as i32 + y >= 0 && j as i32 + y < n as i32 {
                            sum += img[(i as i32 + x) as usize][(j as i32 + y) as usize];
                            count += 1;
                        }
                    }
                }
                result[i][j] = sum / count;
            }
        }
        result
    }
}