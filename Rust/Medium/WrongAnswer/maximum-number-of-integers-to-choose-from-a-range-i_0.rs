impl Solution {
    pub fn max_count(banned: Vec<i32>, n: i32, max_sum: i32) -> i32 {
        
        let mut banned = banned;
        banned.sort();
        let mut l = 1;
        let mut r = n;
        while l < r {
            let m = (l + r + 1) / 2;
            let sum = m * (m + 1) / 2;
            let mut i = 0;
            let mut j = m;
            while i < banned.len() && banned[i] <= m {
                if banned[i] <= j {
                    j = banned[i] - 1;
                }
                i += 1;
            }
            let count = m - j;
            if count + sum <= max_sum {
                l = m;
            } else {
                r = m - 1;
            }
        }
        l
    }
}