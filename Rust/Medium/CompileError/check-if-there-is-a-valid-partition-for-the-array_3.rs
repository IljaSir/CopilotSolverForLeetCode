impl Solution {
    pub fn valid_partition(nums: Vec<i32>) -> bool {
        
        let mut map = std::collections::HashMap::new();
        for i in nums {
            *map.entry(i).or_insert(0) += 1;
        }
        let mut v = map.values().collect::<Vec<_>>();
        v.sort();
        let mut max = *v.last().unwrap();
        let mut min = *v.first().unwrap();
        if max >= 3 {
            return true;
        }
        if max == 2 {
            if min == 1 {
                return true;
            }
            if min == 2 {
                return v.len() == 2;
            }
        }
        if max == 1 {
            if min == 1 {
                return v.len() == 1;
            }
            if min == 2 {
                return v.len() == 2;
            }
        }
        false
    }
}