impl Solution {
    pub fn maximum_bags(capacity: Vec<i32>, rocks: Vec<i32>, additional_rocks: i32) -> i32 {
        
        let mut left = 0;
        let mut right = 0;
        for i in 0..capacity.len() {
            left = left.max(capacity[i] - rocks[i]);
            right += capacity[i];
        }
        while left < right {
            let mid = (left + right + 1) >> 1;
            let mut sum = 0;
            for i in 0..capacity.len() {
                sum += mid.min(capacity[i]) - rocks[i];
            }
            if sum > additional_rocks {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        left
    }
}