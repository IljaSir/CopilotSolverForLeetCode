impl Solution {
    pub fn maximum_bags(capacity: Vec<i32>, rocks: Vec<i32>, additional_rocks: i32) -> i32 {
        
        let mut capacity = capacity;
        let mut rocks = rocks;
        let mut additional_rocks = additional_rocks;
        capacity.sort();
        rocks.sort();
        let mut l = 0;
        let mut r = capacity.len() - 1;
        while l < r {
            let mid = (l + r + 1) >> 1;
            let mut sum = 0;
            for i in 0..mid {
                sum += capacity[i] - rocks[i];
            }
            if sum <= additional_rocks {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        l as i32 + 1
    }
}