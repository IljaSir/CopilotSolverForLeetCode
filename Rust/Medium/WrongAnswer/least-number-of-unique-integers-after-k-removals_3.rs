impl Solution {
    pub fn find_least_num_of_unique_ints(arr: Vec<i32>, k: i32) -> i32 {
        
        use std::collections::HashMap;
        let mut map = HashMap::new();
        for &i in arr.iter() {
            *map.entry(i).or_insert(0) += 1;
        }
        let mut vec = map.values().map(|&x| x).collect::<Vec<i32>>();
        vec.sort();
        let mut count = 0;
        for &i in vec.iter() {
            if k >= i {
                count += 1;
            }
        }
        vec.len() as i32 - count
    }
}