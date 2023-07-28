impl Solution {
    pub fn maximum_bags(capacity: Vec<i32>, rocks: Vec<i32>, additional_rocks: i32) -> i32 {
        
        let mut capacity = capacity;
        let mut rocks = rocks;
        let mut additional_rocks = additional_rocks;
        let n = capacity.len();
        let mut left = 0;
        let mut right = capacity.iter().max().unwrap();
        while left < right {
            let mid = (left + right + 1) / 2;
            let mut need = 0;
            for i in 0..n {
                if capacity[i] - rocks[i] < mid {
                    need += mid - (capacity[i] - rocks[i]);
                }
            }
            if need <= additional_rocks {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        left
    }
}