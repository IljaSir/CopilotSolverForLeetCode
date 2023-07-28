impl Solution {
    pub fn get_collision_times(cars: Vec<Vec<i32>>) -> Vec<f64> {
        
        let mut st = vec![];
        let mut ans = vec![-1.0; cars.len()];
        for i in (0..cars.len()).rev() {
            let pos = cars[i][0] as f64;
            let speed = cars[i][1] as f64;
            while st.len() > 0 {
                let j = st[st.len() - 1];
                let pos2 = cars[j][0] as f64;
                let speed2 = cars[j][1] as f64;
                if speed <= speed2 || (ans[j] > 0.0 && (pos2 - pos) / (speed - speed2) >= ans[j]) {
                    st.pop();
                } else {
                    break;
                }
            }
            if st.len() > 0 {
                let j = st[st.len() - 1];
                let pos2 = cars[j][0] as f64;
                let speed2 = cars[j][1] as f64;
                ans[i] = (pos2 - pos) / (speed - speed2);
            }
            st.push(i);
        }
        ans
    }
}