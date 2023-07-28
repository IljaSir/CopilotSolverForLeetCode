impl Solution {
    pub fn find_least_num_of_unique_ints(arr: Vec<i32>, k: i32) -> i32 {
        
        let mut map = std::collections::HashMap::new();
        for i in arr {
            *map.entry(i).or_insert(0) += 1;
        }
        let mut v = map.values().collect::<Vec<&i32>>();
        v.sort();
        let mut sum = 0;
        for i in v {
            if k < *i {
                sum += 1;
            } else {
                sum += 1;
            }
        }
        sum
    }
}