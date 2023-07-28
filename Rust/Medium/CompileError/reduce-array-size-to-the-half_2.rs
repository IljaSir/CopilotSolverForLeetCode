impl Solution {
    pub fn min_set_size(arr: Vec<i32>) -> i32 {
        
        let mut v = vec![0; 100_001];
        for i in arr {
            v[i as usize] += 1;
        }
        v.sort_by(|a, b| b.cmp(a));
        let mut sum = 0;
        let mut count = 0;
        for i in v {
            sum += i;
            count += 1;
            if sum >= arr.len() / 2 {
                return count;
            }
        }
        0
    }
}