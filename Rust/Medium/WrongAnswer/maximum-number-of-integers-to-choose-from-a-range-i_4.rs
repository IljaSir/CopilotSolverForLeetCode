impl Solution {
    pub fn max_count(banned: Vec<i32>, n: i32, max_sum: i32) -> i32 {
        
        let mut sum = 0;
        let mut count = 0;
        let mut banned = banned;
        banned.sort();
        let mut i = 0;
        while i < banned.len() {
            if sum + banned[i] > max_sum {
                break;
            } else {
                sum += banned[i];
                count += 1;
            }
            i += 1;
        }
        let mut j = banned.len();
        while j > 0 {
            if sum + n - banned[j-1] + 1 <= max_sum {
                sum += n - banned[j-1] + 1;
                count += n - banned[j-1] + 1;
            }
            j -= 1;
        }
        count
    }
}