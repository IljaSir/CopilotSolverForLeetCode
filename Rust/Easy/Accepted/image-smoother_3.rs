impl Solution {
    pub fn image_smoother(img: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
        
        let mut res = vec![vec![0; img[0].len()]; img.len()];
        for i in 0..img.len() {
            for j in 0..img[0].len() {
                let mut sum = 0;
                let mut count = 0;
                for m in -1..=1 {
                    for n in -1..=1 {
                        let x = i as i32 + m;
                        let y = j as i32 + n;
                        if x >= 0 && x < img.len() as i32 && y >= 0 && y < img[0].len() as i32 {
                            sum += img[x as usize][y as usize];
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