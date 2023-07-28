impl Solution {
    pub fn can_eat(candies_count: Vec<i32>, queries: Vec<Vec<i32>>) -> Vec<bool> {
        
        let mut c = vec![0];
        for i in 0..candies_count.len() {
            c.push(c[i] + candies_count[i]);
        }
        let mut ans = Vec::new();
        for q in queries {
            let (t, d, c) = (q[0] as usize, q[1], q[2]);
            let min = d + 1;
            let max = (d + 1) * c;
            if c[t] < min || c[t + 1] > max {
                ans.push(false);
            } else {
                ans.push(true);
            }
        }
        ans
    }
}