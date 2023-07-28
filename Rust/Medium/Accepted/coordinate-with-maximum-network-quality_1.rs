impl Solution {
    pub fn best_coordinate(towers: Vec<Vec<i32>>, radius: i32) -> Vec<i32> {
        
        let mut max = 0;
        let mut res = vec![0, 0];
        for i in 0..51 {
            for j in 0..51 {
                let mut sum = 0;
                for t in &towers {
                    let d = ((t[0] - i).pow(2) + (t[1] - j).pow(2)) as f64;
                    if d <= (radius * radius) as f64 {
                        sum += (t[2] as f64 / (1.0 + d.sqrt())).floor() as i32;
                    }
                }
                if sum > max {
                    max = sum;
                    res[0] = i;
                    res[1] = j;
                }
            }
        }
        res
    }
}