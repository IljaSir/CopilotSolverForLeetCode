impl Solution {
    pub fn max_score(card_points: Vec<i32>, k: i32) -> i32 {
        
        let mut sum = 0;
        for i in 0..k {
            sum += card_points[i as usize];
        }
        let mut max = sum;
        for i in 0..k {
            sum = sum + card_points[card_points.len() - i as usize - 1] - card_points[k as usize - i as usize - 1];
            max = max.max(sum);
        }
        max
    }
}