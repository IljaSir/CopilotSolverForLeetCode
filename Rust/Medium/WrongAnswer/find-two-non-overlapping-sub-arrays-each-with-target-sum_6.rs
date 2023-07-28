impl Solution {
    pub fn min_sum_of_lengths(arr: Vec<i32>, target: i32) -> i32 {
        
        let mut best = vec![-1; arr.len()];
        let mut left = 0;
        let mut right = 0;
        let mut sum = 0;
        let mut min_len = std::i32::MAX;
        while right < arr.len() {
            sum += arr[right];
            while sum > target {
                sum -= arr[left];
                left += 1;
            }
            if sum == target {
                if left > 0 && best[left - 1] != -1 {
                    min_len = min_len.min(best[left - 1] + (right - left + 1) as i32);
                }
                if right + 1 < arr.len() {
                    best[right + 1] = best[right + 1].max((right - left + 1) as i32);
                }
            }
            if right + 1 < arr.len() {
                best[right + 1] = best[right + 1].max(best[right]);
            }
            right += 1;
        }
        if min_len == std::i32::MAX {
            return -1;
        }
        min_len
    }
}