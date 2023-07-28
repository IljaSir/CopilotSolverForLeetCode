impl Solution {
    pub fn max_count(banned: Vec<i32>, n: i32, max_sum: i32) -> i32 {
        
        let mut banned = banned;
        banned.sort();
        let mut max = 0;
        let mut min = 0;
        let mut i = 0;
        let mut j = 0;
        let mut sum = 0;
        while i < banned.len() {
            let mut x = banned[i];
            while j < banned.len() && banned[j] == x {
                j += 1;
            }
            let y = j - i;
            if x > max_sum {
                break;
            }
            if x + (n - y) <= max_sum {
                max = n;
                break;
            }
            if x > sum {
                let t = x - sum - 1;
                let m = t.min(n - i as i32);
                if m > max {
                    max = m;
                    min = i as i32;
                }
            }
            sum += y;
            i = j;
        }
        if sum < max_sum {
            let t = max_sum - sum;
            let m = t.min(n - i as i32);
            if m > max {
                max = m;
                min = i as i32;
            }
        }
        max
    }
}