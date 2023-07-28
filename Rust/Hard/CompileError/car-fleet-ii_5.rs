impl Solution {
    pub fn get_collision_times(cars: Vec<Vec<i32>>) -> Vec<f64> {
        
        let mut stack = vec![];
        let mut res = vec![-1.0; cars.len()];
        for i in (0..cars.len()).rev() {
            let mut time = std::f64::MAX;
            while !stack.is_empty() {
                let (j, t) = stack.pop().unwrap();
                if cars[i][1] <= cars[j][1] {
                    if t > 0.0 {
                        stack.push((j, t));
                    }
                    break;
                } else {
                    time = t;
                    if t < 0.0 || (cars[j][0] - cars[i][0]) as f64 / (cars[i][1] - cars[j][1]) as f64 <= t {
                        break;
                    }
                }
            }
            if !stack.is_empty() {
                let (j, _) = stack.last().unwrap();
                time = (cars[j][0] - cars[i][0]) as f64 / (cars[i][1] - cars[j][1]) as f64;
            }
            if time < std::f64::MAX {
                res[i] = time;
            }
            stack.push((i, time));
        }
        res
    }
}