impl Solution {
    pub fn car_fleet(target: i32, position: Vec<i32>, speed: Vec<i32>) -> i32 {
        
        let mut cars: Vec<(i32, i32)> = position.iter().zip(speed.iter()).map(|(p, s)| (*p, *s)).collect();
        cars.sort_by(|a, b| b.0.cmp(&a.0));
        let mut t = 0;
        let mut res = 0;
        for (p, s) in cars {
            let nt = (target - p) as f64 / s as f64;
            if nt > t {
                t = nt;
                res += 1;
            }
        }
        res
    }
}