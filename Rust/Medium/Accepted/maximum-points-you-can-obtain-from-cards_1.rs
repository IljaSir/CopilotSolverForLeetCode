impl Solution {
    pub fn max_score(card_points: Vec<i32>, k: i32) -> i32 {
        
        let k = k as usize;
        let n = card_points.len();
        let mut sum = 0;
        for i in 0..k {
            sum += card_points[i];
        }
        let mut res = sum;
        for i in 1..=k {
            sum -= card_points[k - i];
            sum += card_points[n - i];
            res = res.max(sum);
        }
        res
    }
}