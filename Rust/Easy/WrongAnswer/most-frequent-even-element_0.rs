impl Solution {
    pub fn most_frequent_even(nums: Vec<i32>) -> i32 {
        
        let mut map = std::collections::HashMap::new();
        for n in nums {
            if n % 2 == 0 {
                *map.entry(n).or_insert(0) += 1;
            }
        }
        let mut max = 0;
        let mut ret = -1;
        for (k, v) in map.iter() {
            if *v > max {
                max = *v;
                ret = *k;
            }
        }
        ret
    }
}