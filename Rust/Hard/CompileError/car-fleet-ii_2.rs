impl Solution {
    pub fn get_collision_times(cars: Vec<Vec<i32>>) -> Vec<f64> {
        
        let n = cars.len();
        let mut ans = vec![-1.0; n];
        let mut st = vec![];
        for i in (0..n).rev() {
            let (pos, speed) = (cars[i][0], cars[i][1]);
            while !st.is_empty() {
                let j = st[st.len() - 1];
                let (pos2, speed2) = (cars[j][0], cars[j][1]);
                if speed <= speed2 || (ans[j] > 0.0 && (pos2 - pos) as f64 / (speed - speed2) as f64 >= ans[j]) {
                    st.pop();
                } else {
                    break;
                }
            }
            if !st.is_empty() {
                let j = st[st.len() - 1];
                let (pos2, speed2) = (cars[j][0], cars[j][1]);
                ans[i] = (pos2 - pos) as f64 / (speed - speed2) as f64;
            }
            st.push(i);
        }
        ans
    }
}