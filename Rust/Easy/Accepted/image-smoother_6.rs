impl Solution {
    pub fn image_smoother(img: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
        
        let mut ans = vec![vec![0; img[0].len()]; img.len()];
        for i in 0..img.len() {
            for j in 0..img[0].len() {
                let mut sum = 0;
                let mut count = 0;
                for k in -1..2 {
                    for l in -1..2 {
                        if i as i32 + k >= 0 && i as i32 + k < img.len() as i32 && j as i32 + l >= 0 && j as i32 + l < img[0].len() as i32 {
                            sum += img[(i as i32 + k) as usize][(j as i32 + l) as usize];
                            count += 1;
                        }
                    }
                }
                ans[i][j] = sum / count;
            }
        }
        ans
    }
}