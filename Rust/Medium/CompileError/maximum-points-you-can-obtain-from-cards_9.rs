impl Solution {
    pub fn max_score(card_points: Vec<i32>, k: i32) -> i32 {
        
        let (mut sum, mut max) = (0, 0);
        let (mut i, mut j) = (0, card_points.len() - k as usize);
        for p in card_points {
            sum += p;
            if i < j {
                sum -= card_points[i];
                i += 1;
            }
            max = max.max(sum);
        }
        max
    }
}