impl Solution {
    pub fn maximum_bags(capacity: Vec<i32>, rocks: Vec<i32>, additional_rocks: i32) -> i32 {
        
        let mut cap = capacity;
        let mut rocks = rocks;
        let mut additional_rocks = additional_rocks;
        let mut i = 0;
        let mut cnt = 0;
        while i < cap.len() {
            if cap[i] - rocks[i] <= additional_rocks {
                additional_rocks -= cap[i] - rocks[i];
                rocks[i] = cap[i];
                cnt += 1;
            } else {
                i += 1;
            }
        }
        cnt
    }
}