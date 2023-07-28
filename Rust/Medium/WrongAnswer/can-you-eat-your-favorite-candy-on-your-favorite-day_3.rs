impl Solution {
    pub fn can_eat(candies_count: Vec<i32>, queries: Vec<Vec<i32>>) -> Vec<bool> {
        
        let mut ans = Vec::new();
        let mut sum = Vec::new();
        sum.push(0);
        for i in 0..candies_count.len() {
            sum.push(sum[i] + candies_count[i]);
        }
        for q in queries {
            let (f_type, f_day, daily_cap) = (q[0] as usize, q[1], q[2]);
            let min = f_day + 1;
            let max = (f_day + 1) * daily_cap;
            let pre = sum[f_type];
            let suc = sum[f_type + 1];
            ans.push(pre < max && suc >= min);
        }
        ans
    }
}