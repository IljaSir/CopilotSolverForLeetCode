impl Solution {
    pub fn min_sum_of_lengths(arr: Vec<i32>, target: i32) -> i32 {
        
        let mut prefix_sum = vec![0; arr.len()];
        prefix_sum[0] = arr[0];
        for i in 1..arr.len() {
            prefix_sum[i] = prefix_sum[i - 1] + arr[i];
        }
        let mut prefix_index = vec![None; arr.len()];
        let mut prefix_min = vec![None; arr.len()];
        let mut suffix_index = vec![None; arr.len()];
        let mut suffix_min = vec![None; arr.len()];
        for i in 0..arr.len() {
            if prefix_sum[i] == target {
                prefix_index[i] = Some(i);
            } else if i > 0 && prefix_index[i - 1].is_some() && prefix_sum[i] - prefix_sum[prefix_index[i - 1].unwrap()] == target {
                prefix_index[i] = Some(prefix_index[i - 1].unwrap());
            }
            if i > 0 {
                prefix_min[i] = if prefix_index[i].is_some() {
                    if prefix_min[i - 1].is_some() {
                        Some(std::cmp::min(i - prefix_index[i].unwrap() + 1, prefix_min[i - 1].unwrap()))
                    } else {
                        Some(i - prefix_index[i].unwrap() + 1)
                    }
                } else {
                    prefix_min[i - 1]
                }
            }
        }
        for i in (0..arr.len()).rev() {
            if prefix_sum[i] == target {
                suffix_index[i] = Some(i);
            } else if i < arr.len() - 1 && suffix_index[i + 1].is_some() && prefix_sum[suffix_index[i + 1].unwrap()] - prefix_sum[i] == target {
                suffix_index[i] = Some(suffix_index[i + 1].unwrap());
            }
            if i < arr.len() - 1 {
                suffix_min[i] = if suffix_index[i].is_some() {
                    if suffix_min[i + 1].is_some() {
                        Some(std::cmp::min(suffix_index[i].unwrap() - i + 1, suffix_min[i + 1].unwrap()))
                    } else {
                        Some(suffix_index[i].unwrap() - i + 1)
                    }
                } else {
                    suffix_min[i + 1]
                }
            }
        }
        let mut ret = -1
    }
}