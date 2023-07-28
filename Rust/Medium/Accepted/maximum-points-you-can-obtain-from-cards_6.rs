impl Solution {
    pub fn max_score(card_points: Vec<i32>, k: i32) -> i32 {
        
        let (mut i, mut j, mut s) = (0, card_points.len() - 1, 0);
        let k = k as usize;
        for _ in 0..k {
            s += card_points[i];
            i += 1;
        }
        let mut res = s;
        for _ in 0..k {
            s -= card_points[i - 1];
            s += card_points[j];
            res = res.max(s);
            i -= 1;
            j -= 1;
        }
        res
    }
}