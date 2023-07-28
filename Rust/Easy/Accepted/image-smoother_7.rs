impl Solution {
    pub fn image_smoother(img: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
        
        let mut ans = vec![vec![0; img[0].len()]; img.len()];
        for i in 0..img.len() {
            for j in 0..img[0].len() {
                let mut sum = 0;
                let mut count = 0;
                let mut x = i as i32;
                let mut y = j as i32;
                for k in 0..3 {
                    for l in 0..3 {
                        x = i as i32 - 1 + k;
                        y = j as i32 - 1 + l;
                        if x >= 0 && x < img.len() as i32 && y >= 0 && y < img[0].len() as i32 {
                            sum += img[x as usize][y as usize];
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