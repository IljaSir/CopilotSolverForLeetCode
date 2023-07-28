impl Solution {
    pub fn car_fleet(target: i32, position: Vec<i32>, speed: Vec<i32>) -> i32 {
        
        let mut cars = Vec::new();
        for i in 0..position.len() {
            cars.push((position[i], speed[i]));
        }
        cars.sort_by(|a, b| b.0.cmp(&a.0));
        let mut ans = 0;
        let mut max_time = 0.0;
        for i in 0..cars.len() {
            let time = (target - cars[i].0) as f64 / cars[i].1 as f64;
            if time > max_time {
                max_time = time;
                ans += 1;
            }
        }
        ans
    }
}