impl Solution {
    pub fn image_smoother(img: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
        
        let m = img.len();
        let n = img[0].len();
        let mut res = vec![vec![0; n]; m];
        for i in 0..m {
            for j in 0..n {
                let mut cnt = 0;
                let mut sum = 0;
                for x in -1..=1 {
                    for y in -1..=1 {
                        let r = i as i32 + x;
                        let c = j as i32 + y;
                        if r >= 0 && r < m as i32 && c >= 0 && c < n as i32 {
                            cnt += 1;
                            sum += img[r as usize][c as usize];
                        }
                    }
                }
                res[i][j] = sum / cnt;
            }
        }
        res
    }
}