impl Solution {
    pub fn valid_partition(nums: Vec<i32>) -> bool {
        
        let mut map = std::collections::HashMap::new();
        let mut max = 0;
        for i in nums.iter() {
            *map.entry(i).or_insert(0) += 1;
            if *i > max {
                max = *i;
            }
        }
        let mut last = 0;
        let mut count = 0;
        let mut last_count = 0;
        for (k, v) in map.iter() {
            if *k == last + 1 {
                count += v;
                last_count = *v;
            } else if *k == last {
                count += v;
                last_count = *v;
            } else {
                last_count = *v;
                count = *v;
            }
            if count >= max {
                return true;
            }
            last = *k;
        }
        false
    }
}