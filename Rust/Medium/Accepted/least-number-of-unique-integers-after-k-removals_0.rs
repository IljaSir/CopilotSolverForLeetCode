impl Solution {
    pub fn find_least_num_of_unique_ints(arr: Vec<i32>, k: i32) -> i32 {
        
        let mut map: std::collections::HashMap<i32, i32> = std::collections::HashMap::new();
        for x in arr {
            *map.entry(x).or_insert(0) += 1;
        }
        let mut freq: Vec<i32> = map.values().map(|x| *x).collect();
        freq.sort();
        let mut ans = freq.len() as i32;
        let mut k = k;
        for x in freq {
            if k >= x {
                k -= x;
                ans -= 1;
            } else {
                break;
            }
        }
        ans
    }
}