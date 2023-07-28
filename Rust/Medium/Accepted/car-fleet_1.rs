impl Solution {
    pub fn car_fleet(target: i32, position: Vec<i32>, speed: Vec<i32>) -> i32 {
        
        let mut time = Vec::new();
        for i in 0..position.len() {
            time.push((position[i], (target - position[i]) as f64 / speed[i] as f64));
        }
        time.sort_by(|a, b| b.0.cmp(&a.0));
        let mut num = 0;
        let mut max_time = 0.0;
        for i in 0..time.len() {
            if time[i].1 > max_time {
                num += 1;
                max_time = time[i].1;
            }
        }
        num
    }
}