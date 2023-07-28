impl Solution {
    pub fn min_set_size(arr: Vec<i32>) -> i32 {
        
        use std::collections::HashMap;
        let mut freq: HashMap<i32, i32> = HashMap::new();
        for i in arr {
            *freq.entry(i).or_insert(0) += 1;
        }
        let mut freq: Vec<i32> = freq.values().map(|x| *x).collect();
        freq.sort();
        freq.reverse();
        let mut sum = 0;
        let mut i = 0;
        while sum < arr.len() as i32 / 2 {
            sum += freq[i];
            i += 1;
        }
        i as i32
    }
}