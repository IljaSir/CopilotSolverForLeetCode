impl Solution {
    pub fn min_sum_of_lengths(arr: Vec<i32>, target: i32) -> i32 {
        
        let mut map = std::collections::HashMap::new();
        let mut sum = 0;
        let mut res = std::i32::MAX;
        let mut min = std::i32::MAX;
        map.insert(0, -1);
        for i in 0..arr.len() {
            sum += arr[i];
            if map.contains_key(&(sum - target)) {
                let idx = map[&(sum - target)];
                if idx != -1 {
                    let len = i as i32 - idx;
                    if len < min {
                        res = std::cmp::min(res, min + len);
                        min = len;
                    } else {
                        res = std::cmp::min(res, len + min);
                    }
                } else {
                    min = i as i32 + 1;
                }
            }
            map.insert(sum, i as i32);
        }
        if res == std::i32::MAX {
            -1
        } else {
            res
        }
    }
}