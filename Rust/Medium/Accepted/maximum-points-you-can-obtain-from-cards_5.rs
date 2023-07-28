impl Solution {
    pub fn max_score(card_points: Vec<i32>, k: i32) -> i32 {
        
        let k = k as usize;
        let mut sum = card_points.iter().take(k).sum::<i32>();
        let mut max = sum;
        for i in 1..=k {
            sum -= card_points[k - i];
            sum += card_points[card_points.len() - i];
            max = max.max(sum);
        }
        max
    }
}