impl Solution {
    pub fn car_fleet(target: i32, position: Vec<i32>, speed: Vec<i32>) -> i32 {
        
        let mut cars = position.iter().zip(speed.iter()).map(|(&p, &s)| (target - p, s)).collect::<Vec<_>>();
        cars.sort_by_key(|&(p, _)| p);
        let mut ans = 0;
        let mut cur = 0.0;
        for &(p, s) in cars.iter().rev() {
            if p as f64 / s as f64 > cur {
                ans += 1;
                cur = p as f64 / s as f64;
            }
        }
        ans
    }
}