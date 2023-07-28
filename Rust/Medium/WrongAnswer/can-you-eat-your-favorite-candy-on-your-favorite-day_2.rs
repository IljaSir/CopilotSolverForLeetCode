impl Solution {
    pub fn can_eat(candies_count: Vec<i32>, queries: Vec<Vec<i32>>) -> Vec<bool> {
        
        let mut answer = Vec::new();
        let mut sum = vec![0; candies_count.len()];
        sum[0] = candies_count[0];
        for i in 1..candies_count.len() {
            sum[i] = sum[i - 1] + candies_count[i];
        }
        for q in queries {
            let (favorite_type, favorite_day, daily_cap) = (q[0] as usize, q[1], q[2]);
            let min = if favorite_type == 0 { 1 } else { sum[favorite_type - 1] + 1 };
            let max = sum[favorite_type];
            answer.push(favorite_day < max / daily_cap && favorite_day + 1 >= min);
        }
        answer
    }
}