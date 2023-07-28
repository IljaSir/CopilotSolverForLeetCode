impl Solution {
    pub fn max_score(card_points: Vec<i32>, k: i32) -> i32 {
        
        let mut sum = 0;
        for i in 0..k as usize {
            sum += card_points[i];
        }
        let mut max = sum;
        for i in 0..k as usize {
            sum -= card_points[k as usize - i - 1];
            sum += card_points[card_points.len() - i - 1];
            if sum > max {
                max = sum;
            }
        }
        max
    }
}