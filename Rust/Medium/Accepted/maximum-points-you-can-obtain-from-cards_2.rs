impl Solution {
    pub fn max_score(card_points: Vec<i32>, k: i32) -> i32 {
        
        let n = card_points.len();
        let mut sum = 0;
        for i in 0..k as usize {
            sum += card_points[i];
        }
        let mut res = sum;
        for i in 0..k as usize {
            sum -= card_points[k as usize - i - 1];
            sum += card_points[n - i - 1];
            res = res.max(sum);
        }
        res
    }
}