impl Solution {
    pub fn min_set_size(arr: Vec<i32>) -> i32 {
        
        let mut arr = arr;
        let mut map = std::collections::HashMap::new();
        for n in arr.iter() {
            *map.entry(n).or_insert(0) += 1;
        }
        let mut arr: Vec<_> = map.iter().collect();
        arr.sort_by_key(|a| -a.1);
        let mut ans = 0;
        let mut sum = 0;
        for i in 0..arr.len() {
            sum += arr[i].1;
            ans += 1;
            if sum >= arr.len() / 2 {
                return ans;
            }
        }
        ans
    }
}