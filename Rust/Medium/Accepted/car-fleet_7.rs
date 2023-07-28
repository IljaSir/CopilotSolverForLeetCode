impl Solution {
    pub fn car_fleet(target: i32, position: Vec<i32>, speed: Vec<i32>) -> i32 {
        
        let mut cars = position.iter().zip(speed.iter()).map(|(&pos, &speed)| (pos, speed)).collect::<Vec<_>>();
        cars.sort_unstable_by(|&a, &b| b.0.cmp(&a.0));
        let mut ans = 0;
        let mut max_time = 0.0;
        for (pos, speed) in cars {
            let time = (target - pos) as f64 / speed as f64;
            if time > max_time {
                max_time = time;
                ans += 1;
            }
        }
        ans
    }
}