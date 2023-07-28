impl Solution {
    pub fn find_least_num_of_unique_ints(arr: Vec<i32>, k: i32) -> i32 {
        
        let mut map = std::collections::HashMap::new();
        for i in arr {
            *map.entry(i).or_insert(0) += 1;
        }
        let mut v: Vec<i32> = map.values().map(|x| *x).collect();
        v.sort();
        let mut i = 0;
        let mut k = k;
        while k > 0 {
            if k >= v[i] {
                k -= v[i];
                i += 1;
            } else {
                break;
            }
        }
        (v.len() - i) as i32
    }
}