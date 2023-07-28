impl Solution {
    pub fn make_sub_k_sum_equal(arr: Vec<i32>, k: i32) -> i64 {
        
        let mut sum = 0;
        let mut k = k as usize;
        let mut count = 0;
        let mut i = 0;
        let mut j = 0;
        let n = arr.len();
        let mut map = std::collections::HashMap::new();
        while j < n {
            sum += arr[j];
            count += 1;
            if count == k {
                *map.entry(sum).or_insert(0) += 1;
                sum -= arr[i];
                i += 1;
                count -= 1;
            }
            j += 1;
        }
        let mut res = 0;
        let mut max = 0;
        for (k, v) in map {
            if v > max {
                res = k;
                max = v;
            }
        }
        let mut ans = 0;
        for i in 0..n {
            if arr[i] != res {
                ans += 1;
            }
        }
        ans
    }
}