impl Solution {
    pub fn largest_overlap(img1: Vec<Vec<i32>>, img2: Vec<Vec<i32>>) -> i32 {
        
        let n = img1.len();
        let mut res = 0;
        for i in 0..n {
            for j in 0..n {
                let mut count = 0;
                for k in 0..n {
                    for l in 0..n {
                        if img1[k][l] == 1 && img2[(k + i) % n][(l + j) % n] == 1 {
                            count += 1;
                        }
                    }
                }
                res = res.max(count);
            }
        }
        res
    }
}