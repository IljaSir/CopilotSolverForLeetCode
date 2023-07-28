impl Solution {
    pub fn maximum_bags(capacity: Vec<i32>, rocks: Vec<i32>, additional_rocks: i32) -> i32 {
        
        let mut rocks = rocks;
        let mut additional_rocks = additional_rocks;
        let mut capacity = capacity;
        let mut ans = 0;
        let mut i = 0;
        while i < capacity.len() {
            let mut j = i + 1;
            while j < capacity.len() {
                if capacity[j] - rocks[j] < capacity[i] - rocks[i] {
                    let tmp = capacity[j];
                    capacity[j] = capacity[i];
                    capacity[i] = tmp;
                    let tmp = rocks[j];
                    rocks[j] = rocks[i];
                    rocks[i] = tmp;
                }
                j += 1;
            }
            if capacity[i] - rocks[i] <= additional_rocks {
                additional_rocks -= capacity[i] - rocks[i];
                ans += 1;
            }
            i += 1;
        }
        ans
    }
}