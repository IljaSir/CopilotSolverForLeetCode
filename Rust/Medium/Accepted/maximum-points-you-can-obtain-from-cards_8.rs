impl Solution {
    pub fn max_score(card_points: Vec<i32>, k: i32) -> i32 {
        
        let (mut sum, mut max) = (0, 0);
        let n = card_points.len() - 1;
        let k = k as usize;
        for i in 0..k {
            sum += card_points[i];
        }
        max = sum;
        for i in 0..k {
            sum += card_points[n-i] - card_points[k-1-i];
            max = max.max(sum);
        }
        max
    }
}