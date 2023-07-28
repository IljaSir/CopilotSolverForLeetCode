impl Solution {
    pub fn maximum_bags(capacity: Vec<i32>, rocks: Vec<i32>, additional_rocks: i32) -> i32 {
        
        let mut capacity = capacity;
        let mut rocks = rocks;
        let mut additional_rocks = additional_rocks;
        capacity.sort();
        rocks.sort();
        let mut l = 0;
        let mut r = rocks.len() as i32 - 1;
        let mut ans = 0;
        while l <= r {
            let mid = (l + r) / 2;
            let mut can = additional_rocks;
            let mut i = rocks.len() - 1;
            while i >= mid as usize {
                can -= capacity[i] - rocks[i];
                i -= 1;
            }
            if can >= 0 {
                ans = mid + 1;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        ans
    }
}