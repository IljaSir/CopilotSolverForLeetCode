impl Solution {
    pub fn get_collision_times(cars: Vec<Vec<i32>>) -> Vec<f64> {
        
        let mut stack = Vec::new();
        let mut res = vec![-1.0; cars.len()];
        for i in (0..cars.len()).rev() {
            let (pos, speed) = (cars[i][0] as f64, cars[i][1] as f64);
            while let Some(&j) = stack.last() {
                let (npos, nspeed) = (cars[j][0] as f64, cars[j][1] as f64);
                if speed <= nspeed || (res[j] > 0.0 && (npos - pos) / (speed - nspeed) >= res[j]) {
                    stack.pop();
                } else {
                    break;
                }
            }
            if let Some(&j) = stack.last() {
                let (npos, nspeed) = (cars[j][0] as f64, cars[j][1] as f64);
                res[i] = (npos - pos) / (speed - nspeed);
            }
            stack.push(i);
        }
        res
    }
}