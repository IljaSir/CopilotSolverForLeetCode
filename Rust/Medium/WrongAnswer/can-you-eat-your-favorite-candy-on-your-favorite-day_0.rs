impl Solution {
    pub fn can_eat(candies_count: Vec<i32>, queries: Vec<Vec<i32>>) -> Vec<bool> {
        
        let n = candies_count.len();
        let mut prefix = vec![0; n + 1];
        for i in 1..=n {
            prefix[i] = prefix[i - 1] + candies_count[i - 1];
        }
        let mut ans = vec![];
        for q in queries {
            let (t, d, c) = (q[0] as usize, q[1], q[2]);
            let min = prefix[t] + 1;
            let max = prefix[t + 1];
            let min_day = min / c;
            let max_day = max / c;
            if d >= min_day && d <= max_day {
                ans.push(true);
            } else {
                ans.push(false);
            }
        }
        ans
    }
}