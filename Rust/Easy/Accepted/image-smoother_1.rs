impl Solution {
    pub fn image_smoother(img: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
        
        let m = img.len();
        let n = img[0].len();
        let mut ans = vec![vec![0; n]; m];
        for i in 0..m {
            for j in 0..n {
                let mut sum = 0;
                let mut cnt = 0;
                for ii in (i as i32 - 1)..=(i as i32 + 1) {
                    for jj in (j as i32 - 1)..=(j as i32 + 1) {
                        if ii >= 0 && ii < m as i32 && jj >= 0 && jj < n as i32 {
                            sum += img[ii as usize][jj as usize];
                            cnt += 1;
                        }
                    }
                }
                ans[i][j] = sum / cnt;
            }
        }
        ans
    }
}