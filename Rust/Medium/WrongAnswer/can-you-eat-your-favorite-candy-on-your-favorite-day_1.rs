impl Solution {
    pub fn can_eat(candies_count: Vec<i32>, queries: Vec<Vec<i32>>) -> Vec<bool> {
        
        let mut prefix_sum = vec![0;candies_count.len()];
        prefix_sum[0] = candies_count[0];
        for i in 1..candies_count.len() {
            prefix_sum[i] = prefix_sum[i-1] + candies_count[i];
        }
        let mut result = Vec::new();
        for q in queries {
            let (type_i, day_i, cap_i) = (q[0] as usize, q[1], q[2]);
            let min = if type_i == 0 { 0 } else { prefix_sum[type_i-1] };
            let max = prefix_sum[type_i];
            let min_day = min / cap_i;
            let max_day = max;
            result.push(day_i >= min_day && day_i < max_day);
        }
        result
    }
}