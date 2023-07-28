impl Solution {
    pub fn max_count(banned: Vec<i32>, n: i32, max_sum: i32) -> i32 {
        
        let mut banned = banned;
        banned.sort_unstable();
        let mut ans = 0;
        let mut i = 0;
        let mut j = 0;
        let mut sum = 0;
        let mut count = 0;
        while i < n {
            if j < banned.len() && banned[j] == i + 1 {
                j += 1;
                i += 1;
                continue;
            }
            if sum + i + 1 > max_sum {
                sum -= banned[j - 1] - 1;
                j += 1;
                count -= 1;
            } else {
                sum += i + 1;
                i += 1;
                count += 1;
            }
            ans = ans.max(count);
        }
        ans
    }
}