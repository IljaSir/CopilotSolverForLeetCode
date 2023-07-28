impl Solution {
    pub fn maximum_beauty(flowers: Vec<i32>, new_flowers: i64, target: i32, full: i32, partial: i32) -> i64 {
        
        let mut complete = 0;
        let mut incomplete = 0;
        let mut min = std::i32::MAX;
        for f in flowers {
            if f >= target {
                complete += 1;
            } else {
                incomplete += 1;
                min = min.min(f);
            }
        }
        let mut ans = complete as i64 * full as i64;
        if incomplete > 0 {
            ans += min as i64 * partial as i64;
        }
        if new_flowers > 0 {
            let mut new = flowers.clone();
            new.sort();
            let mut i = new_flowers;
            let mut j = 0;
            while j < new.len() && i > 0 {
                let f = new[j];
                if f < target {
                    let k = (target - f) as i64;
                    if k <= i {
                        ans += full as i64 - partial as i64 * f as i64;
                        i -= k;
                    } else {
                        ans += full as i64 - partial as i64 * (f as i64 + i);
                        i = 0;
                    }
                }
                j += 1;
            }
            if i > 0 {
                ans += full as i64 * (i / (target as i64));
            }
        }
        ans
    }
}