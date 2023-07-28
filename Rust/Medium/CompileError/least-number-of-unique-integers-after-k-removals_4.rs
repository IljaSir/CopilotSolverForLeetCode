impl Solution {
    pub fn find_least_num_of_unique_ints(arr: Vec<i32>, k: i32) -> i32 {
        
        let mut cnt = std::collections::HashMap::new();
        for a in arr {
            *cnt.entry(a).or_insert(0) += 1;
        }
        let mut cnts = cnt.values().collect::<Vec<_>>();
        cnts.sort();
        let mut i = 0;
        while i < cnts.len() {
            if k >= *cnts[i] {
                k -= *cnts[i];
                i += 1;
            } else {
                break;
            }
        }
        (cnts.len() - i) as i32
    }
}