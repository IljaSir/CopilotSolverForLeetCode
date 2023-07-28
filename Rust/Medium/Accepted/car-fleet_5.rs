impl Solution {
    pub fn car_fleet(target: i32, position: Vec<i32>, speed: Vec<i32>) -> i32 {
        
        if position.is_empty() {
            return 0;
        }
        let mut cars: Vec<(i32, i32)> = position.into_iter().zip(speed.into_iter()).collect();
        cars.sort_by_key(|a| -a.0);
        let mut res = 1;
        let mut t = (target - cars[0].0) as f64 / cars[0].1 as f64;
        for i in 1..cars.len() {
            let tt = (target - cars[i].0) as f64 / cars[i].1 as f64;
            if tt > t {
                res += 1;
                t = tt;
            }
        }
        res
    }
}