impl Solution {
    pub fn car_fleet(target: i32, position: Vec<i32>, speed: Vec<i32>) -> i32 {
        
        let mut pos_speed = position.iter().zip(speed.iter()).collect::<Vec<_>>();
        pos_speed.sort_by_key(|(p, _)| -p);
        let mut time = vec![];
        for (_, s) in pos_speed {
            time.push((target - s) as f64 / *s as f64);
        }
        let mut ans = 0;
        let mut max = 0.0;
        for t in time {
            if t > max {
                ans += 1;
                max = t;
            }
        }
        ans
    }
}