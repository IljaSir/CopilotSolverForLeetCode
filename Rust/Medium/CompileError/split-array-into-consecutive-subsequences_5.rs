impl Solution {
    pub fn is_possible(nums: Vec<i32>) -> bool {
        

        let mut map = std::collections::HashMap::new();
        for num in nums {
            *map.entry(num).or_insert(0) += 1;
        }
        let mut map2 = std::collections::HashMap::new();
        for num in nums {
            if *map.entry(num).or_insert(0) == 0 {
                continue;
            }
            let prev = map2.entry(num - 1).or_insert(0);
            if *prev > 0 {
                *prev -= 1;
                *map2.entry(num).or_insert(0) += 1;
            } else if let Some(next) = map.get(&(num + 1)) {
                if *next > 0 {
                    *map.entry(num + 1).or_insert(0) -= 1;
                    *map.entry(num + 2).or_insert(0) += 1;
                } else {
                    return false;
                }
            } else {
                return false;
            }
            *map.entry(num).or_insert(0) -= 1;
        }
        true
    }
}