impl Solution {
    pub fn maximum_bags(capacity: Vec<i32>, rocks: Vec<i32>, additional_rocks: i32) -> i32 {
        
        let mut l = 0;
        let mut r = additional_rocks;
        let mut ans = 0;
        while l <= r {
            let mid = l + (r - l) / 2;
            let mut cnt = 0;
            for i in 0..capacity.len() {
                if rocks[i] + mid > capacity[i] {
                    cnt += rocks[i] + mid - capacity[i];
                }
            }
            if cnt <= additional_rocks {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        ans
    }
}