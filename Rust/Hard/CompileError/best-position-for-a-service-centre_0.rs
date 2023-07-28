impl Solution {
    pub fn get_min_dist_sum(positions: Vec<Vec<i32>>) -> f64 {
        
        let mut x = 50.0;
        let mut y = 50.0;
        let mut step = 50.0;
        let mut eps = 1e-6;
        while step > eps {
            let mut best = std::f64::MAX;
            for dx in [-1, 1].iter() {
                for dy in [-1, 1].iter() {
                    let nx = x + dx * step;
                    let ny = y + dy * step;
                    let mut sum = 0.0;
                    for p in &positions {
                        sum += ((nx - p[0] as f64).powi(2) + (ny - p[1] as f64).powi(2)).sqrt();
                    }
                    if sum < best {
                        best = sum;
                        x = nx;
                        y = ny;
                    }
                }
            }
            step *= 0.99;
        }
        best
    }
}