impl Solution {
    pub fn find_least_num_of_unique_ints(arr: Vec<i32>, k: i32) -> i32 {
        
        let mut hash = std::collections::HashMap::new();
        for a in arr {
            *hash.entry(a).or_insert(0) += 1;
        }
        let mut v: Vec<i32> = hash.values().map(|x| *x).collect();
        v.sort();
        let mut k = k;
        let mut i = 0;
        while i < v.len() && k >= v[i] {
            k -= v[i];
            i += 1;
        }
        (v.len() - i) as i32
    }
}