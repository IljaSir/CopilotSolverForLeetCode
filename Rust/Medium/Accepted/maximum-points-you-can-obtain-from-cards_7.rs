impl Solution {
    pub fn max_score(card_points: Vec<i32>, k: i32) -> i32 {
        
        let mut sum = 0;
        let mut min_sum = std::i32::MAX;
        let mut sub_sum = 0;
        for i in 0..card_points.len() {
            sum += card_points[i];
            if i < card_points.len() - k as usize {
                sub_sum += card_points[i];
            }
        }
        min_sum = min_sum.min(sub_sum);
        for i in 0..k as usize {
            sub_sum += card_points[card_points.len() - k as usize + i];
            sub_sum -= card_points[i];
            min_sum = min_sum.min(sub_sum);
        }
        sum - min_sum
    }
}