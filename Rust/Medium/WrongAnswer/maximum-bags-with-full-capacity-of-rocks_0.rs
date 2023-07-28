impl Solution {
    pub fn maximum_bags(capacity: Vec<i32>, rocks: Vec<i32>, additional_rocks: i32) -> i32 {
        
        let mut capacity = capacity;
        let mut rocks = rocks;
        let mut additional_rocks = additional_rocks;
        capacity.sort();
        rocks.sort();
        let mut i = 0;
        let mut j = 0;
        while j < rocks.len() && additional_rocks > 0 {
            if capacity[i] > rocks[j] {
                additional_rocks -= capacity[i] - rocks[j];
                rocks[j] = capacity[i];
                i += 1;
            }
            j += 1;
        }
        while additional_rocks > 0 {
            additional_rocks -= capacity[i];
            rocks.push(capacity[i]);
            i += 1;
        }
        i as i32
    }
}