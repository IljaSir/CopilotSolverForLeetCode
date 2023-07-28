impl Solution {
    pub fn unique_occurrences(arr: Vec<i32>) -> bool {
        
        let mut counter = std::collections::HashMap::new();
        for i in arr {
            *counter.entry(i).or_insert(0) += 1;
        }
        let mut counter2 = std::collections::HashMap::new();
        for (_, v) in counter {
            *counter2.entry(v).or_insert(0) += 1;
        }
        for (_, v) in counter2 {
            if v > 1 {
                return false;
            }
        }
        true
    }
}