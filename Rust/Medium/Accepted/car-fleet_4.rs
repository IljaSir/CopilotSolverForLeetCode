impl Solution {
    pub fn car_fleet(target: i32, position: Vec<i32>, speed: Vec<i32>) -> i32 {
        
        let mut cars = position.into_iter().zip(speed.into_iter()).collect::<Vec<_>>();
        cars.sort_unstable_by(|a, b| b.0.cmp(&a.0));
        let mut times = cars.into_iter().map(|(p, s)| (target - p) as f64 / s as f64).collect::<Vec<_>>();
        let mut result = 0;
        let mut i = 0;
        while i < times.len() {
            result += 1;
            let mut j = i + 1;
            while j < times.len() && times[j] <= times[i] {
                j += 1;
            }
            i = j;
        }
        result
    }
}