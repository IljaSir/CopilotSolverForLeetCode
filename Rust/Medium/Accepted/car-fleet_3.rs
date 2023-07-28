impl Solution {
    pub fn car_fleet(target: i32, position: Vec<i32>, speed: Vec<i32>) -> i32 {
        
        let mut cars = position
            .iter()
            .zip(speed.iter())
            .map(|(&pos, &sp)| (pos, sp))
            .collect::<Vec<(i32, i32)>>();
        cars.sort_by(|a, b| b.0.cmp(&a.0));
        let mut ans = 0;
        let mut time = 0.0;
        for (pos, sp) in cars {
            let t = (target - pos) as f64 / sp as f64;
            if t > time {
                ans += 1;
                time = t;
            }
        }
        ans
    }
}