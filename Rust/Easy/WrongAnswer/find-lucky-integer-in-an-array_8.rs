impl Solution {
    pub fn find_lucky(arr: Vec<i32>) -> i32 {
        
        let mut lucky = -1;
        let mut count = std::collections::HashMap::new();
        for i in arr {
            *count.entry(i).or_insert(0) += 1;
        }
        for (k, v) in count {
            if k == v {
                lucky = k;
            }
        }
        lucky
    }
}