impl Solution {
    pub fn image_smoother(img: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
        
        let mut ret = Vec::new();
        for i in 0..img.len() {
            let mut row = Vec::new();
            for j in 0..img[i].len() {
                let mut sum = 0;
                let mut cnt = 0;
                for x in i.saturating_sub(1)..=i+1 {
                    for y in j.saturating_sub(1)..=j+1 {
                        if x < img.len() && y < img[x].len() {
                            sum += img[x][y];
                            cnt += 1;
                        }
                    }
                }
                row.push(sum/cnt);
            }
            ret.push(row);
        }
        ret
    }
}