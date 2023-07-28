impl Solution {
    pub fn min_sum_of_lengths(arr: Vec<i32>, target: i32) -> i32 {
        
        let mut s = 0;
        let mut map = std::collections::HashMap::new();
        map.insert(0, -1);
        let mut ans = std::i32::MAX;
        let mut min = std::i32::MAX;
        for i in 0..arr.len() {
            s += arr[i];
            if let Some(&j) = map.get(&(s - target)) {
                if j != -1 {
                    min = std::cmp::min(min, (i - j) as i32);
                }
                if i as i32 != min {
                    ans = std::cmp::min(ans, min + (i - j) as i32);
                }
            }
            map.insert(s, i as i32);
        }
        if ans == std::i32::MAX {
            -1
        } else {
            ans
        }
    }
}