impl Solution {
    pub fn image_smoother(img: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
        
        let mut result = vec![vec![0; img[0].len()]; img.len()];
        for i in 0..img.len() {
            for j in 0..img[0].len() {
                let mut sum = 0;
                let mut count = 0;
                if i > 0 {
                    if j > 0 {
                        sum += img[i-1][j-1];
                        count += 1;
                    }
                    sum += img[i-1][j];
                    count += 1;
                    if j < img[0].len() - 1 {
                        sum += img[i-1][j+1];
                        count += 1;
                    }
                }
                if j > 0 {
                    sum += img[i][j-1];
                    count += 1;
                }
                sum += img[i][j];
                count += 1;
                if j < img[0].len() - 1 {
                    sum += img[i][j+1];
                    count += 1;
                }
                if i < img.len() - 1 {
                    if j > 0 {
                        sum += img[i+1][j-1];
                        count += 1;
                    }
                    sum += img[i+1][j];
                    count += 1;
                    if j < img[0].len() - 1 {
                        sum += img[i+1][j+1];
                        count += 1;
                    }
                }
                result[i][j] = sum / count;
            }
        }
        result
    }
}