impl Solution {
    pub fn max_count(banned: Vec<i32>, n: i32, max_sum: i32) -> i32 {
        
        let mut banned = banned;
        banned.sort();
        let mut left = 1;
        let mut right = n;
        let mut ans = 0;
        while left <= right {
            let mid = (left + right) / 2;
            let mut sum = 0;
            for i in 0..banned.len() {
                if banned[i] > mid {
                    break;
                }
                sum += banned[i];
            }
            sum += mid * (n - mid + 1);
            if sum <= max_sum {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        ans
    }
}