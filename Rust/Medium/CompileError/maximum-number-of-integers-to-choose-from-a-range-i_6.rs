impl Solution {
    pub fn max_count(banned: Vec<i32>, n: i32, max_sum: i32) -> i32 {
        
        let mut res = 0;
        let mut sum = 0;
        let mut i = 0;
        let mut j = 0;
        let mut banned = banned;
        banned.sort();
        while i < banned.len() && banned[i] <= n {
            while j < banned.len() && banned[j] <= n {
                if sum + banned[j] - banned[i] <= max_sum {
                    sum += banned[j] - banned[i];
                    j += 1;
                } else {
                    break;
                }
            }
            res = res.max(j - i);
            i += 1;
        }
        res.max(n - j as i32 + 1)
    }
}