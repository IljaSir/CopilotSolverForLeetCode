impl Solution {
    pub fn image_smoother(img: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
        
        let mut res = vec![vec![0; img[0].len()]; img.len()];
        for i in 0..img.len() {
            for j in 0..img[0].len() {
                let mut count = 0;
                let mut sum = 0;
                for k in (i as i32 - 1)..=(i as i32 + 1) {
                    for l in (j as i32 - 1)..=(j as i32 + 1) {
                        if k >= 0 && k < img.len() as i32 && l >= 0 && l < img[0].len() as i32 {
                            sum += img[k as usize][l as usize];
                            count += 1;
                        }
                    }
                }
                res[i][j] = sum / count;
            }
        }
        res
    }
}