impl Solution {
    pub fn get_collision_times(cars: Vec<Vec<i32>>) -> Vec<f64> {
        
        let mut stack = Vec::new();
        let mut res = vec![-1.0; cars.len()];
        for i in (0..cars.len()).rev() {
            let (pos_i, speed_i) = (cars[i][0], cars[i][1]);
            while let Some(&j) = stack.last() {
                let (pos_j, speed_j) = (cars[j][0], cars[j][1]);
                if speed_i <= speed_j || (res[j] > 0.0 && (pos_j - pos_i) as f64 / (speed_i - speed_j) as f64 >= res[j]) {
                    stack.pop();
                } else {
                    break;
                }
            }
            if let Some(&j) = stack.last() {
                let (pos_j, speed_j) = (cars[j][0], cars[j][1]);
                res[i] = (pos_j - pos_i) as f64 / (speed_i - speed_j) as f64;
            }
            stack.push(i);
        }
        res
    }
}