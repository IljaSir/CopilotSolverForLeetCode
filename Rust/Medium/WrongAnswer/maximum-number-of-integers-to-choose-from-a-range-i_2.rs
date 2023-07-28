impl Solution {
    pub fn max_count(banned: Vec<i32>, n: i32, max_sum: i32) -> i32 {
        
        let mut banned = banned;
        banned.sort();
        let mut i = 0;
        let mut j = 0;
        let mut sum = 0;
        let mut count = 0;
        while i < banned.len() {
            if banned[i] > n {
                break;
            }
            while j < banned.len() && banned[j] <= banned[i] + i as i32 {
                j += 1;
            }
            if banned[i] - i as i32 > 0 && sum + banned[i] - i as i32 <= max_sum {
                sum += banned[i] - i as i32;
                count += banned[i] - i as i32;
            }
            if sum + j as i32 - i as i32 <= max_sum {
                sum += j as i32 - i as i32;
                count += j as i32 - i as i32;
            } else {
                break;
            }
            i = j;
        }
        count + (n - i as i32).min(max_sum - sum)
    }
}