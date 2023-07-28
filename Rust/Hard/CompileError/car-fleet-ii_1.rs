impl Solution {
    pub fn get_collision_times(cars: Vec<Vec<i32>>) -> Vec<f64> {
        
        let n = cars.len();
        let mut ans = vec![-1.0; n];
        let mut stack: Vec<usize> = vec![];
        for i in (0..n).rev() {
            let (pos_i, speed_i) = (cars[i][0], cars[i][1]);
            while let Some(j) = stack.last() {
                let (pos_j, speed_j) = (cars[*j][0], cars[*j][1]);
                if speed_j >= speed_i || (pos_j - pos_i) as f64 * (speed_i - speed_j) as f64 <= (ans[*j] * speed_j as f64) {
                    stack.pop();
                } else {
                    break;
                }
            }
            if let Some(j) = stack.last() {
                ans[i] = (pos_j - pos_i) as f64 / (speed_i - speed_j) as f64;
            }
            stack.push(i);
        }
        ans
    }
}